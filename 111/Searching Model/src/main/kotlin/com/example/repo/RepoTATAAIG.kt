package com.example.repo

import com.example.dto.Dropdown
import com.example.dto.InputDTO
import io.ktor.http.HttpStatusCode

class RepoTATAAIG {
    private val tataAigDropdown = Dropdown.tataAig

    fun tataAigSearching(body: InputDTO): Any {
        val testStr = body.previousPolicyCarrierCode.lowercase().split(" ").toTypedArray()

        val result =
            tataAigDropdown.asSequence().filter { testStr.all { word -> it.lowercase().contains(word) } }.toList()

        return result.ifEmpty { HttpStatusCode.NoContent }
    }
}
