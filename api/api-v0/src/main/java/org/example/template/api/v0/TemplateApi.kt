package org.example.template.api.v0

import org.example.template.api.v0.dto.TemplateDto
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(
    value = ["/v0/template"],
    consumes = [APPLICATION_JSON_VALUE],
    produces = [APPLICATION_JSON_VALUE],
)
interface TemplateApi {

    @GetMapping
    fun getTemplateById(@RequestParam id: Long): TemplateDto

    @PutMapping
    fun createTemplate(@RequestBody template: TemplateDto): TemplateDto

    @PatchMapping
    fun updateTemplate(@RequestBody template: TemplateDto): TemplateDto
}
