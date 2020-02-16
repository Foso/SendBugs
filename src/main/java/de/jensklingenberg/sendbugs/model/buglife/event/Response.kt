package de.jensklingenberg.kfer.model.buglife.event

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Response(

	@field:SerializedName("app")
	val app: App? = null,

	@field:SerializedName("client_event")
	val clientEvent: ClientEvent? = null,

	@field:SerializedName("email")
	val email: String? = null
)