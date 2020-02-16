package de.jensklingenberg.kfer.model.jira

import javax.annotation.Generated
import com.squareup.moshi.Json

@Generated("com.robohorse.robopojogenerator")
data class CreateIssueRequest(

	@Json(name="fields")
	val fields: Fields? = null
)