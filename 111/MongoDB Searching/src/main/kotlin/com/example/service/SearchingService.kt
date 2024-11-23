package com.example.service

import com.example.di.kodein
import com.example.dto.DropdownDTO
import com.example.repo.RepoBAJAJ
import com.example.repo.RepoICICI
import com.example.repo.RepoTATAAIG
import io.ktor.http.HttpStatusCode
import org.kodein.di.instance

class SearchingService {
    private val repoBAJAJ by kodein.instance<RepoBAJAJ>()
    private val repoICICI by kodein.instance<RepoICICI>()
    private val repoTATAAIG by kodein.instance<RepoTATAAIG>()

    suspend fun     search(body: DropdownDTO): Any? {
        return when(body.product){
            "BAGIC" -> repoBAJAJ.bajajSearch(body)

            "ICICI"-> repoICICI.iciciSearch(body)

            "TAGIC"-> repoTATAAIG.tataAigSearch(body)

            else -> HttpStatusCode.Conflict
        }
    }
}
