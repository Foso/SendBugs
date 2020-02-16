package de.jensklingenberg.kfer.model.buglife.demo

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Report(

	@field:SerializedName("attachments")
	val attachments: List<AttachmentsItem?>? = null,

	@field:SerializedName("device_model")
	val deviceModel: String? = null,

	@field:SerializedName("battery_level")
	val batteryLevel: Double? = null,

	@field:SerializedName("total_memory_bytes")
	val totalMemoryBytes: Long? = null,

	@field:SerializedName("what_happened")
	val whatHappened: String? = null,

	@field:SerializedName("sdk_name")
	val sdkName: String? = null,

	@field:SerializedName("locale")
	val locale: String? = null,

	@field:SerializedName("device_manufacturer")
	val deviceManufacturer: String? = null,

	@field:SerializedName("bundle_version")
	val bundleVersion: String? = null,

	@field:SerializedName("android_mobile_network_subtype")
	val androidMobileNetworkSubtype: Int? = null,

	@field:SerializedName("submission_attempts")
	val submissionAttempts: Int? = null,

	@field:SerializedName("operating_system_version")
	val operatingSystemVersion: String? = null,

	@field:SerializedName("device_brand")
	val deviceBrand: String? = null,

	@field:SerializedName("free_memory_bytes")
	val freeMemoryBytes: Long? = null,

	@field:SerializedName("invocation_method")
	val invocationMethod: Int? = null,

	@field:SerializedName("free_capacity_bytes")
	val freeCapacityBytes: Long? = null,

	@field:SerializedName("sdk_version")
	val sdkVersion: String? = null,

	@field:SerializedName("device_identifier")
	val deviceIdentifier: String? = null,

	@field:SerializedName("wifi_connected")
	val wifiConnected: Boolean? = null,

	@field:SerializedName("attributes")
	val attributes: Attributes? = null,

	@field:SerializedName("total_capacity_bytes")
	val totalCapacityBytes: Long? = null,

	@field:SerializedName("invoked_at")
	val invokedAt: String? = null
)