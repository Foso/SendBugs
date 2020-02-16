package de.jensklingenberg.kfer.model.kfer

import de.jensklingenberg.kfer.model.kfer.Attachment

class BugReport(val title: String = "",val description: String = "",val attachments : List<Attachment> = emptyList())