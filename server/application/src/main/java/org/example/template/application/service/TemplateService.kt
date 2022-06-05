package org.example.template.application.service

import org.example.template.domain.model.TemplateModel
import org.example.template.domain.repository.TemplateRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TemplateService @Autowired constructor(
    private val templateRepository: TemplateRepository,
) {

    fun getById(templateId: Long): TemplateModel {
        return templateRepository.getById(templateId)
            ?: throw NoSuchElementException("Not found template model with id = $templateId")
    }

    fun create(template: TemplateModel): TemplateModel {
        return templateRepository.save(template)
    }

    fun update(template: TemplateModel): TemplateModel {
        templateRepository.update(template)
        return templateRepository.getById(template.id)
            ?: throw IllegalStateException("Not found template model with id = $template")
    }
}
