package org.example.template.standalone

import org.example.template.api.ApiV0Object
import org.example.template.application.ApplicationObject
import org.example.template.domain.DomainObject
import org.example.template.web.WebObject

object StandaloneObject {
    val domain = DomainObject
    val application = ApplicationObject
    val web = WebObject
    val api = ApiV0Object
}
