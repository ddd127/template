package org.example.template.standalone

import org.example.template.api.ApiV0Object
import org.example.template.application.ApplicationObject
import org.example.template.application.ApplicationTestFixtureObject
import org.example.template.domain.DomainObject
import org.example.template.domain.DomainTestFixtureObject
import org.example.template.web.WebObject
import org.example.template.web.WebTestFixtureObject

object StandaloneTestObject {
    val main = StandaloneObject
    val fixture = StandaloneTestFixtureObject
    val apiMain = ApiV0Object
    val domainMain = DomainObject
    val domainFixture = DomainTestFixtureObject
    val applicationMain = ApplicationObject
    val applicationFixture = ApplicationTestFixtureObject
    val webMain = WebObject
    val webFixture = WebTestFixtureObject
}
