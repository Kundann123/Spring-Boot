package com.example.service

import com.example.di.kodein
import com.example.dto.InputDTO
import com.example.exception.BadRequestException
import com.example.repo.RepoBAJAJ
import com.example.repo.RepoICICI
import com.example.repo.RepoTATAAIG
import org.kodein.di.instance

class VahanService {
    private val repoBAJAJ by kodein.instance<RepoBAJAJ>()
    private val repoICICI by kodein.instance<RepoICICI>()
    private val repoTATAAIG by kodein.instance<RepoTATAAIG>()

    fun formatting(body: InputDTO): Any {
        return when (body.product) {
            "BAGIC" -> {
                repoBAJAJ.formattingBAGIC(body)
            }

            "ICICI" -> {
                repoICICI.formattingICICI(body)
            }

            "TAGIC" -> {
                repoTATAAIG.formattingTAGIC(body)
            }

            else -> {
                throw BadRequestException("Invalid Product Key")
            }
        }
    }
}
