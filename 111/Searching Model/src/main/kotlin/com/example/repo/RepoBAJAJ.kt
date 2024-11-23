package com.example.repo

import com.example.dto.Dropdown
import com.example.dto.InputDTO
import io.ktor.http.HttpStatusCode

class RepoBAJAJ {
    private val bajajDropdown = Dropdown.bajaj

    fun bajajSearching(body: InputDTO): Any {
        val testStr = body.previousPolicyCarrierCode.lowercase().split(" ").toTypedArray()

        val result =
            bajajDropdown.asSequence().filter { str -> testStr.all { word -> str.lowercase().contains(word) } }.toList()

        return result.ifEmpty { HttpStatusCode.NoContent }
    }

}
