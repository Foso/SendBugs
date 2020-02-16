package de.jensklingenberg.kfer

import de.jensklingenberg.kfer.data.JiraApi
import de.jensklingenberg.kfer.model.buglife.demo.BuglifeResponse
import de.jensklingenberg.kfer.model.jira.CreateIssueRequest
import de.jensklingenberg.kfer.model.jira.Fields
import de.jensklingenberg.kfer.model.jira.Issuetype
import de.jensklingenberg.kfer.model.jira.Project
import de.jensklingenberg.kfer.model.kfer.Attachment
import de.jensklingenberg.kfer.model.kfer.BugReport
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson
import io.ktor.request.receive
import io.ktor.routing.post
import io.ktor.routing.route
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.reactivex.rxkotlin.subscribeBy
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*


fun main(args: Array<String>) {
    val server = embeddedServer(Netty, 8080) {
        install(ContentNegotiation) {
            gson {
                setPrettyPrinting()
            }
        }
        routing {
            route("/buglife") {
                post("/api/v1/client_events.json") {}
                post("/api/v1/reports.json") {
                    val buglifeResponse = call.receive<BuglifeResponse>()
                    handleRequest(buglifeResponse)
                }

            }
        }
    }
    server.start(wait = true)

}

fun handleRequest(buglifeResponse: BuglifeResponse) {
    val report = buglifeResponse.report

    val description = """
                    |deviceModel : ${report?.deviceModel}
                    |battery : ${report?.batteryLevel}
                    |operatingSystemVersion : ${report?.operatingSystemVersion}
                """.trimIndent()

    buglifeResponse.report?.attachments?.get(1)?.let {
        val attachments = listOf(Attachment(it.base64AttachmentData,it.filename))
        sendToJira(BugReport(report?.whatHappened
                ?: "", description, attachments))
    }
}


fun sendToJira( bugReport: BugReport) {
    val attachmentsItem = bugReport.attachments.first()
    val jiraUrl = "xx"
    val jiraUserName = "xx"
    val jiraPwdOrApiToken = "xx"


    val byteArr = Base64.getDecoder().decode(attachmentsItem.base64AttachmentData)

    val fields = Fields(bugReport.title, Issuetype("Bug"), Project(key = "MYP"), bugReport.description)
    val createIssueRequest = CreateIssueRequest(fields)

    val client = OkHttpClient.Builder().addInterceptor { chain ->
        val basic = Credentials.basic(jiraUserName, jiraPwdOrApiToken)
        val ongoing = chain.request().newBuilder()
        ongoing.addHeader("Authorization", basic)
        chain.proceed(ongoing.build())
    }.build()

    val retrofit = Retrofit.Builder()
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(jiraUrl)
            .build()

    val api = retrofit.create(JiraApi::class.java)

    val requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), byteArr)
    val body = MultipartBody.Part.createFormData("file", attachmentsItem.filename, requestFile)

    api.createIssue(createIssueRequest)
            .flatMap {
                api.uploadFile(body, it.key ?: "")
            }
            .subscribeBy()
}
