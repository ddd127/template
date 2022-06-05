package org.example.template.domain.repository

import org.example.template.domain.AbstractDomainTest
import org.example.template.domain.model.TemplateModel
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class TemplateRepositoryTest : AbstractDomainTest() {

    @Autowired
    private lateinit var templateRepository: TemplateRepository

    @Test
    fun `test save and get`() {
        val model = TemplateModel(-1, "name", "value")
        val saved = templateRepository.save(model)
        assertEquals(
            model.copy(id = saved.id),
            saved,
        )
        val got = templateRepository.getById(saved.id)
        assertEquals(
            saved,
            got,
        )
    }
}
