package de.jensklingenberg.kfer.model.buglife.demo

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class AttachmentsItem(

	@field:SerializedName("base64_attachment_data")
	val base64AttachmentData: String? = null,

	@field:SerializedName("filename")
	val filename: String? = null,

	@field:SerializedName("mime_type")
	val mimeType: String? = null,

	@field:SerializedName("log_version")
	val logVersion: String? = null
)