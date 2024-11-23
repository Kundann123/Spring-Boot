package com.example.repo

import com.example.dto.Dropdown
import com.example.dto.InputDTO
import io.ktor.http.HttpStatusCode

class RepoICICI {
    private val iciciDropdown = Dropdown.icici

    fun iciciSearching(body: InputDTO): Any {
        val testStr = body.previousPolicyCarrierCode.lowercase().split(" ").toTypedArray()

        val result =
            iciciDropdown.asSequence().filter { str -> testStr.all { word -> str.lowercase().contains(word) } }.toList()

        return result.ifEmpty { HttpStatusCode.NoContent }
    }
}
