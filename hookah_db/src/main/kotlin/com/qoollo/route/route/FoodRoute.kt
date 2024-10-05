package com.qoollo.route.route

import com.qoollo.domain.model.info.FoodInfo
import com.qoollo.domain.repository.IFoodRepository
import com.qoollo.route.mapper.toDomain
import com.qoollo.route.model.InsertFoodRouteModel
import com.qoollo.route.model.FoodInfoRouteModel
import com.qoollo.route.util.toUUID
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
import java.util.*


private const val FOODS = "foods"
private const val FOOD = "food"
private const val BARS = "bars"
private const val ID = "id"
private const val BAR_ID = "bar_id"

fun Route.insertFood() {
    val rep by inject<IFoodRepository>()
    post("/$BARS/{$BAR_ID}/$FOOD") {
        val barId = call.parameters[BAR_ID]?.toUUID() ?: run {
            call.respond(HttpStatusCode.BadRequest)
            return@post
        }
        val food = call.receive<FoodInfoRouteModel>()
        val id = rep.insert(barId, food.toDomain())
        call.respond(HttpStatusCode.OK, id)
    }
}

fun Route.insertFoods() {
    val rep by inject<IFoodRepository>()
    post("/$BARS/{$BAR_ID}/$FOODS") {
        val barId = call.parameters[BAR_ID]?.toUUID() ?: run {
            call.respond(HttpStatusCode.BadRequest)
            return@post
        }
        val food = call.receive<List<FoodInfoRouteModel>>()
        val ids = rep.insertAll(
            barId,
            food.map { foodModel ->
                foodModel.toDomain()
            }
        )
        call.respond(HttpStatusCode.OK, ids)
    }
}

fun Route.insertFoodInBars() {
    val rep by inject<IFoodRepository>()
    post("/$BARS/$FOOD") {
        val data = call.receive<InsertFoodRouteModel>()
        val bars = data.bars
        val food: List<FoodInfo> = data.food.map { foodModel -> foodModel.toDomain() }
        val ids = rep.insertAllInBars(bars, food)
        call.respond(HttpStatusCode.OK, ids)
    }
}

fun Route.updateFood() {
    val rep by inject<IFoodRepository>()
    put("/$FOOD") {
        val food = call.receive<FoodInfoRouteModel>()
        rep.update(food.toDomain())
        call.respond(HttpStatusCode.OK)
    }
}

fun Route.deleteFoodFromBar() {
    val rep by inject<IFoodRepository>()
    delete("/$BARS/{$BAR_ID}/$FOOD/{$ID}") {
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

fun Route.deleteFoodFromBars() {
    val rep by inject<IFoodRepository>()
    delete("/$BARS/$FOOD/{$ID}") {
        val id = call.parameters[ID]?.toUUID() ?: run {
            call.respond(HttpStatusCode.BadRequest)
            return@delete
        }
        val barIds = call.receive<List<UUID>>()
        rep.deleteFromBars(barIds, id)
        call.respond(HttpStatusCode.OK)
    }
}

fun Route.deleteFood() {
    val rep by inject<IFoodRepository>()
    delete("/$FOOD/{$ID}") {
        val id = call.parameters[ID]?.toUUID() ?: run {
            call.respond(HttpStatusCode.BadRequest)
            return@delete
        }
        rep.deleteFromAllBars(id)
        call.respond(HttpStatusCode.OK)
    }
}