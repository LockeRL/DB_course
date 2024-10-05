package com.qoollo.route.route

import com.qoollo.domain.repository.IBarsRepository
import com.qoollo.route.mapper.toDomain
import com.qoollo.route.mapper.toRoute
import com.qoollo.route.model.*
import com.qoollo.route.util.toUUID
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject


private const val BARS = "bars"
private const val BAR = "bar"
private const val COMMENTS = "comments"
private const val FOODS = "foods"
private const val DRINKS = "drinks"
private const val HOOKAHS = "hookahs"
private const val ID = "id"
private const val BAR_ID = "bar_id"

fun Route.insertBar() {
    val rep by inject<IBarsRepository>()
    post("/$BAR") {
        val bar = call.receive<BarRouteModel>()
        val id = rep.insertBar(bar.toDomain())
        call.respond(HttpStatusCode.OK, id)
    }
}

fun Route.insertBars() {
    val rep by inject<IBarsRepository>()
    post("/$BARS") {
        val bars = call.receive<List<BarRouteModel>>()
        val ids = rep.insertAllBars(bars.map { bar -> bar.toDomain() })
        call.respond(HttpStatusCode.OK, ids)
    }
}

fun Route.updateBar() {
    val rep by inject<IBarsRepository>()
    put("/$BARS") {
        val bar = call.receive<BarRouteModel>()
        val id = bar.id ?: run {
            call.respond(HttpStatusCode.BadRequest)
            return@put
        }
        rep.updateBar(id, bar.toDomain())
        call.respond(HttpStatusCode.OK)
    }
}

fun Route.deleteBar() {
    val rep by inject<IBarsRepository>()
    delete("/$BARS/{$ID}") {
        val id = call.parameters[ID]?.toUUID() ?: run {
            call.respond(HttpStatusCode.BadRequest)
            return@delete
        }
        rep.deleteBar(id)
        call.respond(HttpStatusCode.OK)
    }
}

fun Route.getBars() {
    val rep by inject<IBarsRepository>()
    get("/$BARS") {
        val bars: List<BarInfoRouteModel> = rep.getBarsWithScore().map { bar -> bar.toRoute() }
        call.respond(HttpStatusCode.OK, bars)
    }
}

fun Route.getBarFood() {
    val rep by inject<IBarsRepository>()
    get("/$BARS/{$BAR_ID}/$FOODS") {
        val barId = call.parameters[BAR_ID]?.toUUID() ?: run {
            call.respond(HttpStatusCode.BadRequest)
            return@get
        }
        val food: List<FoodInfoRouteModel> = rep.getBarWithFood(barId).map { food -> food.toRoute() }
        call.respond(HttpStatusCode.OK, food)
    }
}

fun Route.getBarDrinks() {
    val rep by inject<IBarsRepository>()
    get("/$BARS/{$BAR_ID}/$DRINKS") {
        val barId = call.parameters[BAR_ID]?.toUUID() ?: run {
            call.respond(HttpStatusCode.BadRequest)
            return@get
        }
        val drinks: List<DrinkInfoRouteModel> = rep.getBarWithDrinks(barId).map { drink -> drink.toRoute() }
        call.respond(HttpStatusCode.OK, drinks)
    }
}

fun Route.getBarHookahs() {
    val rep by inject<IBarsRepository>()
    get("/$BARS/{$BAR_ID}/$HOOKAHS") {
        val barId = call.parameters[BAR_ID]?.toUUID() ?: run {
            call.respond(HttpStatusCode.BadRequest)
            return@get
        }
        val hookahs: List<HookahInfoRouteModel> = rep.getBarWithHookahs(barId).map { hookah -> hookah.toRoute() }
        call.respond(HttpStatusCode.OK, hookahs)
    }
}

fun Route.getBarComments() {
    val rep by inject<IBarsRepository>()
    get("/$BARS/{$BAR_ID}/$COMMENTS") {
        val barId = call.parameters[BAR_ID]?.toUUID() ?: run {
            call.respond(HttpStatusCode.BadRequest)
            return@get
        }
        val comments: List<CommentInfoRouteModel> = rep.getBarComments(barId).map { comment -> comment.toRoute() }
        call.respond(HttpStatusCode.OK, comments)
    }
}