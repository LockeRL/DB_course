package com.qoollo.route.route

import com.qoollo.domain.repository.IOrganizationsRepository
import com.qoollo.route.mapper.toDomain
import com.qoollo.route.model.OrgRouteModel
import com.qoollo.route.util.toUUID
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject


private const val ORGS = "orgs"
private const val ID = "id"

fun Route.insertOrg() {
    val rep by inject<IOrganizationsRepository>()
    post("/$ORGS") {
        val org = call.receive<OrgRouteModel>()
        val id = rep.insertOrg(org.toDomain())
        call.respond(HttpStatusCode.OK, id)
    }
}

fun Route.deleteOrg() {
    val rep by inject<IOrganizationsRepository>()
    delete("/$ORGS/{$ID}") {
        val id = call.parameters[ID]?.toUUID() ?: run {
            call.respond(HttpStatusCode.BadRequest)
            return@delete
        }
        rep.deleteOrg(id)
        call.respond(HttpStatusCode.OK)
    }
}

fun Route.updateOrg() {
    val rep by inject<IOrganizationsRepository>()
    put("/$ORGS") {
        val org = call.receive<OrgRouteModel>()
        val id = org.id ?: run {
            call.respond(HttpStatusCode.BadRequest)
            return@put
        }
        rep.updateOrg(id, org.toDomain())
        call.respond(HttpStatusCode.OK)
    }
}