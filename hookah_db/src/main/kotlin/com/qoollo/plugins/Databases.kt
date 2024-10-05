package com.qoollo.plugins

import com.qoollo.datasource.local.table.*
import io.ktor.server.application.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

private const val BASE_INFO_PATH = "db."
private const val URL_PATH = "url"
private const val USER_PATH = "user"
private const val DRIVER_PATH = "driver"
private const val PASSWORD_PATH = "password"

fun Application.configureDatabases() {
    val url = environment.config.property("$BASE_INFO_PATH$URL_PATH").getString()
    val user = environment.config.property("$BASE_INFO_PATH$USER_PATH").getString()
    val driver = environment.config.property("$BASE_INFO_PATH$DRIVER_PATH").getString()
    val password = environment.config.property("$BASE_INFO_PATH$PASSWORD_PATH").getString()


    val databaseConnect = Database.connect(
        url = url,
        user = user,
        driver = driver,
        password = password
    )

    createTables()
}

private fun createTables() = transaction {
    SchemaUtils.create(
        AdminsBarsTable,
        AdminsTable,
        BarsDrinksTable,
        BarsFoodTable,
        BarsHookahsTable,
        BarsTable,
        CommentsTable,
        DrinksTable,
        FoodTable,
        HookahsTable,
        OrganizationsTable,
        UsersTable
    )
}
