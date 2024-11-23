package com.example.model.schema

import com.fasterxml.jackson.annotation.JsonProperty
import io.ktor.server.auth.*
import kotlinx.serialization.Serializable


@Serializable
data class User(
    @JsonProperty("_id")
    val _id: String? = null,
    var id: Int,
    val name: String,
    val gender: String,
    val state: String,
    val colours: List<String>
) : Principal

