package org.example.template.domain.repository.impl

import org.example.template.domain.db.Tables.TEMPLATE
import org.example.template.domain.db.tables.records.TemplateRecord
import org.example.template.domain.model.TemplateModel
import org.example.template.domain.repository.TemplateRepository
import org.jooq.DSLContext
import org.jooq.exception.NoDataFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class TemplateRepositoryImpl @Autowired constructor(
    private val dslContext: DSLContext,
) : TemplateRepository {

    override fun getById(templateId: Long): TemplateModel? =
        dslContext.selectFrom(TEMPLATE)
            .where(TEMPLATE.ID.equal(templateId))
            .fetchOne(::recordToModel)

    override fun save(template: TemplateModel) =
        dslContext.insertInto(TEMPLATE)
            .set(modelToRecord(template, false))
            .returning()
            .fetchOptional()
            .orElseThrow(::NoDataFoundException)
            .let(::recordToModel)

    override fun update(template: TemplateModel) {
        dslContext.update(TEMPLATE)
            .set(modelToRecord(template, true))
            .where(TEMPLATE.ID.equal(template.id))
            .execute()
    }

    companion object {

        private fun modelToRecord(
            model: TemplateModel,
            withId: Boolean,
        ) = TemplateRecord().apply {
            if (withId) {
                id = model.id
            }
            name = model.name
            value = model.value
        }

        private fun recordToModel(
            record: TemplateRecord,
        ) = TemplateModel(
            record.id,
            record.name,
            record.value,
        )
    }
}
