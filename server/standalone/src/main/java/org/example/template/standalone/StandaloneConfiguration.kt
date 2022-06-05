package org.example.template.standalone

import org.example.template.web.WebConfiguration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@ComponentScan
@Import(WebConfiguration::class)
@EnableAutoConfiguration
class StandaloneConfiguration
