package org.example.template.web

import org.example.template.api.ApiV0Object
import org.example.template.application.ApplicationObject
import org.example.template.application.ApplicationTestFixtureObject
import org.example.template.domain.DomainObject
import org.example.template.domain.DomainTestFixtureObject

object WebTestFixtureObject {
    val main = WebObject
    val apiMain = ApiV0Object
    val domainMain = DomainObject
    val domainFixture = DomainTestFixtureObject
    val applicationMain = ApplicationObject
    val applicationFixture = ApplicationTestFixtureObject
}
