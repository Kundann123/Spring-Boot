package com.example.repo

import com.example.dto.Dropdown
import com.example.dto.InputDTO
import io.ktor.http.HttpStatusCode

class RepoICICI {

    private val iciciDropdown = Dropdown.icici

    fun formattingICICI(body: InputDTO): Any {

        val result = mutableListOf<String>()
        val str = body.previousPolicyCarrierCode.lowercase().split(" ").toTypedArray()

        for (i in iciciDropdown.indices) {
            var flag = 0
            for (j in str.indices) {
                if (!iciciDropdown[i].lowercase().contains(str[j])) {
                    flag = 1
                    break
                }
            }
            if (flag == 0) {
                result.add(iciciDropdown[i])
            }
        }
        println(result)
        return result.ifEmpty { HttpStatusCode.NoContent }
    }
}
