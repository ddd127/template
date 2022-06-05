package org.example.template.domain.repository

import org.example.template.domain.model.TemplateModel

interface TemplateRepository {

    fun getById(templateId: Long): TemplateModel?

    fun save(template: TemplateModel): TemplateModel

    fun update(template: TemplateModel)
}
