package com.qoollo.plugins

import com.qoollo.domain.repository.IUsersRepository
import io.ktor.server.application.*
import io.ktor.server.auth.*
import org.koin.ktor.ext.inject
import kotlin.text.Charsets.UTF_8


const val AUTH_BASIC = "auth-basic"

fun Application.configureBasicAuthentication() {
    val usersRep by inject<IUsersRepository>()
    install(Authentication) {
        basic(AUTH_BASIC) {
            realm = "Access to database"
            charset = UTF_8
            validate { credentials ->
                val user = usersRep.read(credentials.name, credentials.password) ?: return@validate null
                UserIdPrincipal(user.id.toString())
            }
        }
    }
}