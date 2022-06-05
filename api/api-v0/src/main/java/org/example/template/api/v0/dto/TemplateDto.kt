package org.example.template.api.v0.dto

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class TemplateDto @JsonCreator constructor(

    @field:JsonProperty("id", required = true)
    @get:JsonProperty("id", required = true)
    @param:JsonProperty("id", required = true)
    val id: Long,

    @field:JsonProperty("name", required = true)
    @get:JsonProperty("name", required = true)
    @param:JsonProperty("name", required = true)
    val name: String,

    @field:JsonProperty("value", required = false)
    @get:JsonProperty("value", required = false)
    @param:JsonProperty("value", required = false)
    val value: String?,
)
