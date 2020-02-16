package de.jensklingenberg.kfer.model.buglife.event

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class App(

	@field:SerializedName("bundle_identifier")
	val bundleIdentifier: String? = null,

	@field:SerializedName("bundle_name")
	val bundleName: String? = null,

	@field:SerializedName("platform")
	val platform: String? = null
)