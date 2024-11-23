package com.example.di

import com.example.repo.RepoBAJAJ
import com.example.repo.RepoICICI
import com.example.repo.RepoTATAAIG
import com.example.service.SearchService
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

val kodein=DI{
    bind<SearchService>() with singleton { SearchService() }
    bind<RepoBAJAJ>() with singleton { RepoBAJAJ() }
    bind<RepoICICI>() with singleton { RepoICICI() }
    bind<RepoTATAAIG>() with singleton { RepoTATAAIG() }
}