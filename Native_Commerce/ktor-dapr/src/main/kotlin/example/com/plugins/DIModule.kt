package example.com.plugins

import example.com.repository.UsersRepository
import example.com.service.UsersService
import io.dapr.client.DaprClient
import io.dapr.client.DaprClientBuilder
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

fun configureDI() {
    stopKoin()
    startKoin {
        modules(daprModule)
        modules(serviceDIModule)
        modules(repoDIModule)
    }
}

val serviceDIModule = module {
    singleOf(::UsersService)
}

val repoDIModule = module {
    singleOf(::UsersRepository)
}

fun configureDaprModule() {
    startKoin {
        modules(daprModule)
    }
}

private const val DAPR_CONNECTION_TIMEOUT = 30000

val daprModule = module {
    val daprClient = DaprClientBuilder().build()
    daprClient.waitForSidecar(DAPR_CONNECTION_TIMEOUT).block()
    single<DaprClient> {
        daprClient
    }
}
