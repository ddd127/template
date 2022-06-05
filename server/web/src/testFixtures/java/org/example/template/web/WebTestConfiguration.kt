package org.example.template.web

import org.example.template.application.ApplicationTestConfiguration
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
            value = [WebConfiguration::class],
        ),
    ],
)
@Import(ApplicationTestConfiguration::class)
@EnableAutoConfiguration
class WebTestConfiguration
