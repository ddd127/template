package org.example.template.web.v0

import org.example.template.api.v0.TemplateApi
import org.example.template.api.v0.dto.TemplateDto
import org.example.template.application.service.TemplateService
import org.example.template.web.v0.converter.dtoToModel
import org.example.template.web.v0.converter.modelToDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller

@Controller
class TemplateApiImpl @Autowired constructor(
    private val templateService: TemplateService,
) : TemplateApi {

    override fun getTemplateById(id: Long): TemplateDto =
        templateService.getById(id).let(::modelToDto)

    override fun createTemplate(template: TemplateDto): TemplateDto =
        templateService.create(dtoToModel(template)).let(::modelToDto)

    override fun updateTemplate(template: TemplateDto): TemplateDto =
        templateService.update(dtoToModel(template)).let(::modelToDto)
}
