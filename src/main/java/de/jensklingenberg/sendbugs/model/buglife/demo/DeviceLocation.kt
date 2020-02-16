package de.jensklingenberg.kfer.model.buglife.demo

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class DeviceLocation(

	@field:SerializedName("flag")
	val flag: Int? = null,

	@field:SerializedName("attribute_type")
	val attributeType: String? = null,

	@field:SerializedName("attribute_value")
	val attributeValue: String? = null
)