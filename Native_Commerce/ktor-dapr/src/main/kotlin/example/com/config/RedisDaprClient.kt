package example.com.config

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import example.com.util.getKoinInstance
import io.dapr.client.DaprClient

private const val STATE_STORE_NAME = "redis.statestore"
val daprInstance = getKoinInstance<DaprClient>()
const val REDIS_ERR_MSG = "Dapr Redis failed"

fun String.setState(value: Any?) {
    daprInstance.saveState(STATE_STORE_NAME, this, value).block()
}

fun String.getState(): Either<String, Any> {
    return runCatching {
        when (val data = daprInstance.getState(STATE_STORE_NAME, this, Any::class.java).block()?.value) {
            null -> REDIS_ERR_MSG.left()
            else -> data.right()
        }
    }.getOrElse {
        log.error("Dapr Client failed with Exception, could not fetch detail with key: $this")
        REDIS_ERR_MSG.left()
    }
}
