package com.qoollo.route.route

import com.qoollo.domain.repository.IAdminsRepository
import com.qoollo.domain.repository.IUsersRepository
import com.qoollo.route.mapper.toDomain
import com.qoollo.route.mapper.toRoute
import com.qoollo.route.model.AdminInfoRouteModel
import com.qoollo.route.model.AdminRouteModel
import com.qoollo.route.model.BarInfoRouteModel
import com.qoollo.route.util.toUUID
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject


private const val ADMIN = "admin"
private const val ADMINS = "admins"
private const val BARS = "bars"
private const val ID = "id"
private const val BAR_ID = "bar_id"
private const val LOGIN = "login"
private const val PASSWORD = "password"

fun Route.insertAdmin() {
    val rep by inject<IAdminsRepository>()
    post("/$BARS/{$BAR_ID}/$ADMIN") {
        val barId = call.parameters[BAR_ID]?.toUUID() ?: run {
            call.respond(HttpStatusCode.BadRequest)
            return@post
        }
        val admin = call.receive<AdminRouteModel>()
        val id = rep.insert(barId, admin.toDomain())
        call.respond(HttpStatusCode.OK, id)
    }
}

fun Route.insertAdmins() {
    val rep by inject<IAdminsRepository>()
    post("/$BARS/{$BAR_ID}/$ADMINS") {
        val barId = call.parameters[BAR_ID]?.toUUID() ?: run {
            call.respond(HttpStatusCode.BadRequest)
            return@post
        }
        val admins = call.receive<List<AdminRouteModel>>()
        val ids = rep.insertAll(
            barId,
            admins.map { admin ->
                admin.toDomain()
            }
        )
        call.respond(HttpStatusCode.OK, ids)
    }
}

fun Route.updateAdmin() {
    val rep by inject<IAdminsRepository>()
    put("/$ADMINS") {
        val admin = call.receive<AdminRouteModel>()
        val id = admin.id ?: run {
            call.respond(HttpStatusCode.BadRequest)
            return@put
        }
        rep.update(id, admin.toDomain())
        call.respond(HttpStatusCode.OK)
    }
}

fun Route.deleteAdmin() {
    val rep by inject<IAdminsRepository>()
    delete("/$ADMINS/{$ID}") {
        val id = call.parameters[ID]?.toUUID() ?: run {
            call.respond(HttpStatusCode.BadRequest)
            return@delete
        }
        rep.delete(id)
        call.respond(HttpStatusCode.OK)
    }
}

fun Route.deleteAdminInBar() {
    val rep by inject<IAdminsRepository>()
    delete("/$BARS/{$BAR_ID}/$ADMINS/{$ID}") {
        val id = call.parameters[ID]?.toUUID() ?: run {
            call.respond(HttpStatusCode.BadRequest)
            return@delete
        }
        val barId = call.parameters[BAR_ID]?.toUUID() ?: run {
            call.respond(HttpStatusCode.BadRequest)
            return@delete
        }
        rep.delete(barId, id)
        call.respond(HttpStatusCode.OK)
    }
}

fun Route.deleteAdminsInBar() {
    val rep by inject<IAdminsRepository>()
    delete("/$BARS/{$BAR_ID}/$ADMINS") {
        val barId = call.parameters[BAR_ID]?.toUUID() ?: run {
            call.respond(HttpStatusCode.BadRequest)
            return@delete
        }
        rep.deleteAllInBar(barId)
        call.respond(HttpStatusCode.OK)
    }
}

fun Route.loginAdmin() {
    val adminRep by inject<IAdminsRepository>()
    val userRep by inject<IUsersRepository>()
    get("/$ADMINS{$LOGIN}{$PASSWORD}") {
        val login = call.parameters[LOGIN] ?: run {
            call.respond(HttpStatusCode.BadRequest)
            return@get
        }
        val password = call.parameters[PASSWORD] ?: run {
            call.respond(HttpStatusCode.BadRequest)
            return@get
        }
        val user = userRep.read(login, password)
        if (user?.id == null)
            run {
                call.respond(HttpStatusCode.NotFound)
                return@get
            }
        val admin = adminRep.read(user.id) ?: run {
            call.respond(HttpStatusCode.NotFound)
            return@get
        }
        call.respond(
            HttpStatusCode.OK,
            AdminInfoRouteModel(
                admin = admin.toRoute(),
                user = user.toRoute()
            )
        )
    }
}

fun Route.getAdministeredBars() {
    val rep by inject<IAdminsRepository>()
    get("/$ADMINS/{$ID}/$BARS") {
        val id = call.parameters[ID]?.toUUID() ?: run {
            call.respond(HttpStatusCode.BadRequest)
            return@get
        }
        val bars: List<BarInfoRouteModel> = rep.getAdministeredBars(id).map { barInfo -> barInfo.toRoute() }
        call.respond(HttpStatusCode.OK, bars)
    }
}