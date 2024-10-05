package com.qoollo.route.route

import com.qoollo.domain.repository.ICommentsRepository
import com.qoollo.route.mapper.toDomain
import com.qoollo.route.model.CommentRouteModel
import com.qoollo.route.util.toUUID
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject


private const val COMMENTS = "comments"
private const val ID = "id"

fun Route.insertComment() {
    val rep by inject<ICommentsRepository>()
    post("/$COMMENTS") {
        val comment = call.receive<CommentRouteModel>()
        val id = rep.insert(comment.toDomain())
        call.respond(HttpStatusCode.OK, id)
    }
}

fun Route.deleteComment() {
    val rep by inject<ICommentsRepository>()
    delete("/$COMMENTS/{$ID}") {
        val id = call.parameters[ID]?.toUUID() ?: run {
            call.respond(HttpStatusCode.BadRequest)
            return@delete
        }
        rep.delete(id)
        call.respond(HttpStatusCode.OK)
    }
}

fun Route.updateComment() {
    val rep by inject<ICommentsRepository>()
    put("/$COMMENTS") {
        val comment = call.receive<CommentRouteModel>()
        val id = comment.id ?: run {
            call.respond(HttpStatusCode.BadRequest)
            return@put
        }
        rep.update(id, comment.toDomain())
        call.respond(HttpStatusCode.OK)
    }
}