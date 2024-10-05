package com.qoollo.route.route

import com.qoollo.domain.model.info.HookahInfo
import com.qoollo.domain.repository.IHookahsRepository
import com.qoollo.route.mapper.toDomain
import com.qoollo.route.model.InsertHookahsRouteModel
import com.qoollo.route.model.HookahInfoRouteModel
import com.qoollo.route.util.toUUID
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
import java.util.*


private const val HOOKAHS = "hookahs"
private const val HOOKAH = "hookah"
private const val BARS = "bars"
private const val ID = "id"
private const val BAR_ID = "bar_id"

fun Route.insertHookah() {
    val rep by inject<IHookahsRepository>()
    post("/$BARS/{$BAR_ID}/$HOOKAH") {
        val barId = call.parameters[BAR_ID]?.toUUID() ?: run {
            call.respond(HttpStatusCode.BadRequest)
            return@post
        }
        val hookah = call.receive<HookahInfoRouteModel>()
        val id = rep.insert(barId, hookah.toDomain())
        call.respond(HttpStatusCode.OK, id)
    }
}

fun Route.insertHookahs() {
    val rep by inject<IHookahsRepository>()
    post("/$BARS/{$BAR_ID}/$HOOKAHS") {
        val barId = call.parameters[BAR_ID]?.toUUID() ?: run {
            call.respond(HttpStatusCode.BadRequest)
            return@post
        }
        val hookahs = call.receive<List<HookahInfoRouteModel>>()
        val ids = rep.insertAll(
            barId,
            hookahs.map { hookah ->
                hookah.toDomain()
            }
        )
        call.respond(HttpStatusCode.OK, ids)
    }
}

fun Route.insertHookahsInBars() {
    val rep by inject<IHookahsRepository>()
    post("/$BARS/$HOOKAHS") {
        val data = call.receive<InsertHookahsRouteModel>()
        val bars = data.bars
        val hookahs: List<HookahInfo> = data.hookahs.map { hookah -> hookah.toDomain() }
        val ids = rep.insertAllInBars(bars, hookahs)
        call.respond(HttpStatusCode.OK, ids)
    }
}

fun Route.updateHookah() {
    val rep by inject<IHookahsRepository>()
    put("/$HOOKAH") {
        val hookah = call.receive<HookahInfoRouteModel>()
        rep.update(hookah.toDomain())
        call.respond(HttpStatusCode.OK)
    }
}

fun Route.deleteHookahFromBar() {
    val rep by inject<IHookahsRepository>()
    delete("/$BARS/{$BAR_ID}/$HOOKAHS/{$ID}") {
        val id = call.parameters[ID]?.toUUID() ?: run {
            call.respond(HttpStatusCode.BadRequest)
            return@delete
        }
        val barId = call.parameters[ID]?.toUUID() ?: run {
            call.respond(HttpStatusCode.BadRequest)
            return@delete
        }
        rep.deleteFromBar(barId, id)
        call.respond(HttpStatusCode.OK)
    }
}

fun Route.deleteHookahFromBars() {
    val rep by inject<IHookahsRepository>()
    delete("/$BARS/$HOOKAHS/{$ID}") {
        val id = call.parameters[ID]?.toUUID() ?: run {
            call.respond(HttpStatusCode.BadRequest)
            return@delete
        }
        val barIds = call.receive<List<UUID>>()
        rep.deleteFromBars(barIds, id)
        call.respond(HttpStatusCode.OK)
    }
}

fun Route.deleteHookah() {
    val rep by inject<IHookahsRepository>()
    delete("/$HOOKAHS/{$ID}") {
        val id = call.parameters[ID]?.toUUID() ?: run {
            call.respond(HttpStatusCode.BadRequest)
            return@delete
        }
        rep.deleteFromAllBars(id)
        call.respond(HttpStatusCode.OK)
    }
}