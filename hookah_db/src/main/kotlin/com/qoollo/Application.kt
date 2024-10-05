package com.qoollo

import com.qoollo.plugins.*
import io.ktor.server.application.*
import io.ktor.server.netty.EngineMain

fun main(args: Array<String>) = EngineMain.main(args)

fun Application.module() {
    configureBasicAuthentication()
    configureSerialization()
    configureDi()
    configureDatabases()
    configureRouting()
}
