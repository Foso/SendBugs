package de.jensklingenberg.kfer.model.buglife.event

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class ClientEvent(

	@field:SerializedName("device_identifier")
	val deviceIdentifier: String? = null,

	@field:SerializedName("sdk_version")
	val sdkVersion: String? = null,

	@field:SerializedName("event_name")
	val eventName: String? = null,

	@field:SerializedName("sdk_name")
	val sdkName: String? = null,

	@field:SerializedName("bundle_version")
	val bundleVersion: String? = null
)