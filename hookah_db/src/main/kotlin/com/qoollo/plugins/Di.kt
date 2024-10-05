package com.qoollo.plugins

import com.qoollo.di.*
import io.ktor.server.application.*
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger


fun Application.configureDi() {
    install(Koin) {
        slf4jLogger()
        modules(
            daoModule,
            serviceModule,
            repositoryModule
        )
    }
}