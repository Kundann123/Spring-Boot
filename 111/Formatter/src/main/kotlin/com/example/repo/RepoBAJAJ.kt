package com.example.repo

import com.example.dto.Dropdown
import com.example.dto.InputDTO
import io.ktor.http.HttpStatusCode

class RepoBAJAJ {

    private val bajajDropdown = Dropdown.bajaj

    fun formattingBAGIC(body: InputDTO): Any {

        val result = mutableListOf<String>()
        val str = body.previousPolicyCarrierCode.lowercase().split(" ").toTypedArray()

        for (i in bajajDropdown.indices) {
            var flag = 0
            for (j in str.indices) {
                if (!bajajDropdown[i].lowercase().contains(str[j])) {
                    flag = 1
                    break
                }
            }
            if (flag == 0) {
                result.add(bajajDropdown[i])
            }
        }
        println(result)
        return result.ifEmpty { HttpStatusCode.NoContent }
    }
}
