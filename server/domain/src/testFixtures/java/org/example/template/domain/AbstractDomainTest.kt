package org.example.template.domain

import io.zonky.test.db.AutoConfigureEmbeddedDatabase
import io.zonky.test.db.AutoConfigureEmbeddedDatabase.DatabaseProvider.ZONKY
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource

@SpringBootTest
@ContextConfiguration(
    classes = [DomainTestConfiguration::class],
)
@AutoConfigureEmbeddedDatabase(provider = ZONKY)
@TestPropertySource(locations = ["classpath:test-domain.properties"])
abstract class AbstractDomainTest
