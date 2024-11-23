package com.example.repo

import com.example.dbconfig.MongoDBConfigFactory
import com.example.dto.DropdownDTO
import com.example.dto.InputDTO
import io.ktor.http.HttpStatusCode
import org.bson.types.ObjectId

class RepoTATAAIG {
    private val col = MongoDBConfigFactory.getDatabase().getCollection<InputDTO>("TataAigDropdown")

    suspend fun tataAigSearch(body: DropdownDTO): Any? {
        val objectId = ObjectId("64d70f31ebaf1ad8b2b2bc70") //ObjectId of TATA AIG Dropdown
        val dropdown = col.findOneById(objectId)?.data

        val testStr = body.ppcc.lowercase().split(" ").toTypedArray()
        val result = dropdown?.filter { str -> testStr.all { word -> str.lowercase().contains(word) } }

        return if (result?.size == 0) HttpStatusCode.NoContent
        else result
    }
}
