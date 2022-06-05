package org.example.template.web.v0.converter

import org.example.template.api.v0.dto.TemplateDto
import org.example.template.domain.model.TemplateModel

fun dtoToModel(dto: TemplateDto) = TemplateModel(
    dto.id,
    dto.name,
    dto.value,
)

fun modelToDto(model: TemplateModel) = TemplateDto(
    model.id,
    model.name,
    model.value,
)
