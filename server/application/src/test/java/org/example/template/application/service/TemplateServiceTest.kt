package org.example.template.application.service

import org.example.template.application.AbstractApplicationTest
import org.example.template.domain.model.TemplateModel
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class TemplateServiceTest : AbstractApplicationTest() {

    @Autowired
    private lateinit var templateService: TemplateService

    @Test
    fun `test save update get`() {
        val model = TemplateModel(-1, "name", "value")
        val created = templateService.create(model)
        assertEquals(model.copy(id = created.id), created)
        val expectedUpdated = created.copy(value = null)
        val updated = templateService.update(expectedUpdated)
        assertEquals(expectedUpdated, updated)
        val got = templateService.getById(updated.id)
        assertEquals(expectedUpdated, got)
    }
}
