package com.example.repo

import com.example.dbconfig.MongoDBConfigFactory
import com.example.dto.DropdownDTO
import com.example.dto.InputDTO
import io.ktor.http.HttpStatusCode
import org.bson.types.ObjectId

class RepoICICI {
    private val col = MongoDBConfigFactory.getDatabase().getCollection<InputDTO>("IciciDropdown")

    suspend fun iciciSearch(body: DropdownDTO): Any? {
        val objectId = ObjectId("64d70fa5ebaf1ad8b2b2bc74")
        val dropdown = col.findOneById(objectId)?.data

        val testStr = body.ppcc.lowercase().split(" ").toTypedArray()
        val result = dropdown?.filter { str -> testStr.all { word -> str.lowercase().contains(word) } }

        return if (result?.size == 0) HttpStatusCode.NoContent
        else result
    }
}
