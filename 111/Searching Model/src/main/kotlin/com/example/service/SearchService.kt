package com.example.service

import com.example.di.kodein
import com.example.dto.InputDTO
import com.example.repo.RepoBAJAJ
import com.example.repo.RepoICICI
import com.example.repo.RepoTATAAIG
import io.ktor.http.HttpStatusCode
import org.kodein.di.instance

class SearchService {
    private val repoBAJAJ by kodein.instance<RepoBAJAJ>()
    private val repoICICI by kodein.instance<RepoICICI>()
    private val repoTATAAIG by kodein.instance<RepoTATAAIG>()

    fun searching(body: InputDTO): Any {
        return when (body.product) {
            "BAGIC" -> repoBAJAJ.bajajSearching(body)

            "ICICI" -> repoICICI.iciciSearching(body)

            "TAGIC" -> repoTATAAIG.tataAigSearching(body)

            else -> HttpStatusCode.BadRequest
        }
    }

}
