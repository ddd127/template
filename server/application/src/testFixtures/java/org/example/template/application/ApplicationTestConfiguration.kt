package org.example.template.application

import org.example.template.domain.DomainTestConfiguration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType
import org.springframework.context.annotation.Import

@Configuration
@ComponentScan(
    excludeFilters = [
        ComponentScan.Filter(
            type = FilterType.ASSIGNABLE_TYPE,
            value = [ApplicationConfiguration::class],
        ),
    ],
)
@Import(DomainTestConfiguration::class)
@EnableAutoConfiguration
class ApplicationTestConfiguration
