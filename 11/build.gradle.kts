
val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    kotlin("jvm") version "1.9.22"
    id("io.ktor.plugin") version "2.3.7"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.22"
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(11)
    }
}

group = "com.example"
version = "0.0.1"

application {
    mainClass.set("com.example.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}
repositories {
        mavenCentral()
    }


    dependencies {
        implementation("io.ktor:ktor-server-content-negotiation-jvm")
        implementation("io.ktor:ktor-server-core-jvm")
        implementation("io.ktor:ktor-serialization-jackson-jvm")
        implementation("io.ktor:ktor-serialization-gson-jvm")
        implementation("io.ktor:ktor-serialization-kotlinx-json-jvm")
        implementation("io.ktor:ktor-server-call-logging-jvm")
        implementation("io.ktor:ktor-server-swagger-jvm")
        implementation("io.ktor:ktor-server-openapi")
        implementation("io.ktor:ktor-server-default-headers-jvm")
        implementation("io.ktor:ktor-server-cors-jvm")
        implementation("io.ktor:ktor-server-host-common-jvm")
        implementation("io.ktor:ktor-server-status-pages-jvm")
        implementation("io.ktor:ktor-server-resources")
        implementation("io.ktor:ktor-server-netty-jvm")
        implementation("ch.qos.logback:logback-classic:$logback_version")
        implementation("org.kotlincrypto.macs:hmac:0.3.0")
        implementation("com.ingonoka:grpc-endpoint-authentication-jvm:v0.2")
        testImplementation("io.ktor:ktor-server-tests-jvm")
        testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
        testImplementation("io.mockk:mockk:1.12.0")
        implementation("org.litote.kmongo:kmongo:4.5.0")
        implementation("org.litote.kmongo:kmongo-coroutine:4.5.1")
        implementation("io.insert-koin:koin-core:3.2.0")
        implementation("io.ktor:ktor-client-auth:$ktor_version")
        implementation("io.ktor:ktor-auth:1.6.4")
        implementation("io.ktor:ktor-server-auth:$ktor_version")
        implementation("commons-codec:commons-codec:1.16.1")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        implementation("io.ktor:ktor-server-cio:$ktor_version")
        implementation("io.ktor:ktor-server-test-host:$ktor_version")
        implementation("io.ktor:ktor-server-auth:$ktor_version")
        implementation("io.ktor:ktor-server-auth-jwt:$ktor_version")
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.2")
        implementation("io.ktor:ktor-serialization:$ktor_version")
        implementation("org.litote.kmongo:kmongo-coroutine:4.3.0")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
    }