package org.example.template.web.v0

import org.example.template.api.v0.TemplateApi
import org.example.template.api.v0.dto.TemplateDto
import org.example.template.web.AbstractWebTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class TemplateApiTest : AbstractWebTest() {

    @Autowired
    private lateinit var templateApi: TemplateApi

    @Test
    fun `test create`() {
        val dto = TemplateDto(-1, "name", "value")
        val saved = templateApi.createTemplate(dto)
        assertEquals(dto.copy(id = saved.id), saved)
    }
}
