package com.example.repo

import com.example.dto.Dropdown
import com.example.dto.InputDTO
import io.ktor.http.HttpStatusCode

class RepoTATAAIG {

    private val tataAigDropdown = Dropdown.tataAig

    fun formattingTAGIC(body: InputDTO): Any {

        val result = mutableListOf<String>()
        val testStr = body.previousPolicyCarrierCode.lowercase().split(" ").toTypedArray()

        for (i in tataAigDropdown.indices) {
            val str=tataAigDropdown[i]
            val mainStr = str.lowercase().split(" ").toTypedArray()
            var mainStrInd = 0
            var testStrInd = 0

            while (mainStrInd < mainStr.size && testStrInd < testStr.size) {
                if (mainStr[mainStrInd] == testStr[testStrInd]) {
                    testStrInd++
                }
                mainStrInd++
            }

            if (testStrInd == testStr.size) {
                result.add(str)
            }

        }
        println("RESULT: $result")
        return result.ifEmpty { HttpStatusCode.NoContent }
    }
}
