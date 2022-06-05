package org.example.template.web

import org.example.template.application.AbstractApplicationTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource

@SpringBootTest
@ContextConfiguration(
    classes = [WebTestConfiguration::class],
)
@TestPropertySource(locations = ["classpath:test-web.properties"])
abstract class AbstractWebTest : AbstractApplicationTest()
