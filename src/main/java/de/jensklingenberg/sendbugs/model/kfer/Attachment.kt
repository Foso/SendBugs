package de.jensklingenberg.kfer.model.kfer

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

data class Attachment(

	@field:SerializedName("base64_attachment_data")
	val base64AttachmentData: String? = null,

	@field:SerializedName("filename")
	val filename: String? = null

)