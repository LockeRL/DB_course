package com.qoollo.route.route

import com.qoollo.domain.repository.IUsersRepository
import com.qoollo.route.mapper.toDomain
import com.qoollo.route.mapper.toRoute
import com.qoollo.route.model.UserRouteModel
import com.qoollo.route.util.toUUID
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject


private const val USERS = "users"
private const val LOGIN = "login"
private const val PASSWORD = "password"
private const val ID = "id"

fun Route.getUser() {
    val rep by inject<IUsersRepository>()
    get("/$USERS/{$ID}") {
        val id = call.parameters[ID]?.toUUID() ?: run {
            call.respond(HttpStatusCode.BadRequest)
            return@get
        }
        val user = rep.read(id) ?: run {
            call.respond(HttpStatusCode.NotFound)
            return@get
        }
        call.respond(HttpStatusCode.OK, user.toRoute())
    }
}

fun Route.login() {
    val rep by inject<IUsersRepository>()
    get("/$USERS{$LOGIN}{$PASSWORD}") {
        val login = call.parameters[LOGIN] ?: run {
            call.respond(HttpStatusCode.BadRequest)
            return@get
        }
        val password = call.parameters[PASSWORD] ?: run {
            call.respond(HttpStatusCode.BadRequest)
            return@get
        }

        val user = rep.read(login, password) ?: run {
            call.respond(HttpStatusCode.NotFound)
            return@get
        }
        call.respond(HttpStatusCode.OK, user.toRoute())
    }
}

fun Route.insertUser() {
    val rep by inject<IUsersRepository>()
    post("/$USERS") {
        println("Here")
        val user = call.receive<UserRouteModel>()

        val userInfo = rep.read(user.login, user.password)
        if (userInfo != null) {
            call.respond(HttpStatusCode.Conflict)
            return@post
        }

        val id = rep.insert(user.toDomain())
        call.respond(HttpStatusCode.OK, id)
    }
}

fun Route.deleteUser() {
    val rep by inject<IUsersRepository>()
    delete("/$USERS/{$ID}") {
        val id = call.parameters[ID]?.toUUID() ?: run {
            call.respond(HttpStatusCode.BadRequest)
            return@delete
        }
        rep.delete(id)
        call.respond(HttpStatusCode.OK)
    }
}

fun Route.updateUser() {
    val rep by inject<IUsersRepository>()
    put("/$USERS") {
        val user = call.receive<UserRouteModel>()
        val id = user.id ?: run {
            call.respond(HttpStatusCode.BadRequest)
            return@put
        }

        val userInfo = rep.read(user.login, user.password)
        if (userInfo != null) {
            call.respond(HttpStatusCode.Conflict)
            return@put
        }

        rep.update(id, user.toDomain())
        call.respond(HttpStatusCode.OK)
    }
}