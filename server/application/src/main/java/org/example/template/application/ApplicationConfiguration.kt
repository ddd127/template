package org.example.template.application

import org.example.template.domain.DomainConfiguration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@ComponentScan
@Import(DomainConfiguration::class)
@EnableAutoConfiguration
class ApplicationConfiguration
