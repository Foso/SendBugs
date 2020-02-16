package de.jensklingenberg.kfer.model.buglife.demo

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class BuglifeResponse(

	@field:SerializedName("app")
	val app: App? = null,

	@field:SerializedName("report")
	val report: Report? = null,

	@field:SerializedName("email")
	val email: String? = null
)