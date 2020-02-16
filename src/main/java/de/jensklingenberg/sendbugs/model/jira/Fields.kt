package de.jensklingenberg.kfer.model.jira

import javax.annotation.Generated
import com.squareup.moshi.Json

@Generated("com.robohorse.robopojogenerator")
data class Fields(

	@Json(name="summary")
	val summary: String? = null,

	@Json(name="issuetype")
	val issuetype: Issuetype? = null,

	@Json(name="project")
	val project: Project? = null,

	@Json(name="description")
	val description: String? = null
)