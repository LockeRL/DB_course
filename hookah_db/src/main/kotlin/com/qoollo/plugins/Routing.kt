package com.qoollo.plugins

import com.qoollo.route.route.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    configureUsersRouting()
    configureOrganizationsRouting()
    configureCommentsRouting()
    configureAdminsRouting()
    configureBarsRoute()
    configureDrinksRoute()
    configureFoodRoute()
    configureHookahsRoute()
}

private fun Application.configureUsersRouting() {
    routing {
        insertUser()
        login()
        authenticate(AUTH_BASIC) {
            updateUser()
            deleteUser()
            getUser()
        }
    }
}

private fun Application.configureOrganizationsRouting() {
    routing {
        authenticate(AUTH_BASIC) {
            insertOrg()
            updateOrg()
            deleteOrg()
        }
    }
}

private fun Application.configureCommentsRouting() {
    routing {
        authenticate(AUTH_BASIC) {
            insertComment()
            updateComment()
            deleteComment()
        }
    }
}

private fun Application.configureAdminsRouting() {
    routing {
        loginAdmin()
        authenticate(AUTH_BASIC) {
            insertAdmin()
            insertAdmins()
            updateAdmin()
            deleteAdmin()
            deleteAdminsInBar()
            deleteAdminInBar()
            getAdministeredBars()
        }
    }
}

private fun Application.configureBarsRoute() {
    routing {
        getBars()
        getBarFood()
        getBarDrinks()
        getBarHookahs()
        getBarComments()
        authenticate(AUTH_BASIC) {
            insertBar()
            insertBars()
            updateBar()
            deleteBar()
        }
    }
}

private fun Application.configureDrinksRoute() {
    routing {
        authenticate(AUTH_BASIC) {
            insertDrink()
            insertDrinks()
            insertDrinksInBars()
            updateDrink()
            deleteDrink()
            deleteDrinkFromBar()
            deleteDrinkFromBars()
        }
    }
}

private fun Application.configureFoodRoute() {
    routing {
        authenticate(AUTH_BASIC) {
            insertFood()
            insertFoods()
            insertFoodInBars()
            updateFood()
            deleteFood()
            deleteFoodFromBar()
            deleteFoodFromBars()
        }
    }
}

private fun Application.configureHookahsRoute() {
    routing {
        authenticate(AUTH_BASIC) {
            insertHookah()
            insertHookahs()
            insertHookahsInBars()
            updateHookah()
            deleteHookah()
            deleteHookahFromBar()
            deleteHookahFromBars()
        }
    }
}
