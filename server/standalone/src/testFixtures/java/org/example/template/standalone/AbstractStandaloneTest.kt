package org.example.template.standalone

import org.example.template.web.AbstractWebTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource

@SpringBootTest
@ContextConfiguration(
    classes = [StandaloneTestConfiguration::class],
)
@TestPropertySource(locations = ["classpath:test-standalone.properties"])
abstract class AbstractStandaloneTest : AbstractWebTest()
