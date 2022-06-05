package org.example.template.application

import org.example.template.domain.AbstractDomainTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource

@SpringBootTest
@ContextConfiguration(
    classes = [ApplicationTestConfiguration::class],
)
@TestPropertySource(locations = ["classpath:test-application.properties"])
abstract class AbstractApplicationTest : AbstractDomainTest()
