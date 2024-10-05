package com.qoollo.route.route

import com.qoollo.domain.model.info.DrinkInfo
import com.qoollo.domain.repository.IDrinksRepository
import com.qoollo.route.mapper.toDomain
import com.qoollo.route.model.InsertDrinksRouteModel
import com.qoollo.route.model.DrinkInfoRouteModel
import com.qoollo.route.util.toUUID
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
import java.util.UUID


private const val DRINKS = "drinks"
private const val DRINK = "drink"
private const val BARS = "bars"
private const val ID = "id"
private const val BAR_ID = "bar_id"

fun Route.insertDrink() {
    val rep by inject<IDrinksRepository>()
    post("/$BARS/{$BAR_ID}/$DRINK") {
        val barId = call.parameters[BAR_ID]?.toUUID() ?: run {
            call.respond(HttpStatusCode.BadRequest)
            return@post
        }
        val drink = call.receive<DrinkInfoRouteModel>()
        val id = rep.insert(barId, drink.toDomain())
        call.respond(HttpStatusCode.OK, id)
    }
}

fun Route.insertDrinks() {
    val rep by inject<IDrinksRepository>()
    post("/$BARS/{$BAR_ID}/$DRINKS") {
        val barId = call.parameters[BAR_ID]?.toUUID() ?: run {
            call.respond(HttpStatusCode.BadRequest)
            return@post
        }
        val drinks = call.receive<List<DrinkInfoRouteModel>>()
        val ids = rep.insertAll(
            barId,
            drinks.map { drink ->
                drink.toDomain()
            }
        )
        call.respond(HttpStatusCode.OK, ids)
    }
}

fun Route.insertDrinksInBars() {
    val rep by inject<IDrinksRepository>()
    post("/$BARS/$DRINKS") {
        val data = call.receive<InsertDrinksRouteModel>()
        val bars = data.bars
        val drinks: List<DrinkInfo> = data.drinks.map { drink -> drink.toDomain() }
        val ids = rep.insertAllInBars(bars, drinks)
        call.respond(HttpStatusCode.OK, ids)
    }
}

fun Route.updateDrink() {
    val rep by inject<IDrinksRepository>()
    put("/$DRINKS") {
        val drink = call.receive<DrinkInfoRouteModel>()
        rep.update(drink.toDomain())
        call.respond(HttpStatusCode.OK)
    }
}

fun Route.deleteDrinkFromBar() {
    val rep by inject<IDrinksRepository>()
    delete("/$BARS/{$BAR_ID}/$DRINKS/{$ID}") {
        val id = call.parameters[ID]?.toUUID() ?: run {
            call.respond(HttpStatusCode.BadRequest)
            return@delete
        }
        val barId = call.parameters[BAR_ID]?.toUUID() ?: run {
            call.respond(HttpStatusCode.BadRequest)
            return@delete
        }
        rep.deleteFromBar(barId, id)
        call.respond(HttpStatusCode.OK)
    }
}

fun Route.deleteDrinkFromBars() {
    val rep by inject<IDrinksRepository>()
    delete("/$BARS/$DRINKS/{$ID}") {
        val id = call.parameters[ID]?.toUUID() ?: run {
            call.respond(HttpStatusCode.BadRequest)
            return@delete
        }
        val barIds = call.receive<List<UUID>>()
        rep.deleteFromBars(barIds, id)
        call.respond(HttpStatusCode.OK)
    }
}

fun Route.deleteDrink() {
    val rep by inject<IDrinksRepository>()
    delete("/$DRINKS/{$ID}") {
        val id = call.parameters[ID]?.toUUID() ?: run {
            call.respond(HttpStatusCode.BadRequest)
            return@delete
        }
        rep.deleteFromAllBars(id)
        call.respond(HttpStatusCode.OK)
    }
}