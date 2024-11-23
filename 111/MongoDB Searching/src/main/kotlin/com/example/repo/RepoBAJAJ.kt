package com.example.repo

import com.example.dbconfig.MongoDBConfigFactory
import com.example.dto.DropdownDTO
import com.example.dto.InputDTO
import io.ktor.http.HttpStatusCode
import org.bson.types.ObjectId

class RepoBAJAJ {
    private val col = MongoDBConfigFactory.getDatabase().getCollection<InputDTO>("BajajDropdown")

    suspend fun bajajSearch(body: DropdownDTO): Any? {
        val userId = ObjectId("64d62a36880aed1b6fd13c9e")
        val dropdown = col.findOneById(userId)?.data

        val testStr = body.ppcc.lowercase().split(" ").toTypedArray()
        val result = dropdown?.filter { str -> testStr.all { word -> str.lowercase().contains(word) } }

        return if (result?.size == 0) HttpStatusCode.NoContent
        else result
    }
}
