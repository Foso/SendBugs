package de.jensklingenberg.kfer.data


import de.jensklingenberg.kfer.model.jira.CreateIssueRequest
import io.reactivex.Single
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.http.*

interface JiraApi {

    @POST("issue")
    @Headers("Content-Type: application/json")
    fun createIssue(@Body request: CreateIssueRequest) : Single<CreateIssueResponse>

    @Multipart
    @POST("issue/{issueKey}/attachments")
    @Headers("X-Atlassian-Token: no-check")
    fun uploadFile(@Part  file: MultipartBody.Part,@Path("issueKey") issueKey: String) : Single<ResponseBody>

}