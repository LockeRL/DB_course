package com.qoollo.datasource.local.table

import com.qoollo.datasource.local.entity.db.UserEntity
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.statements.UpdateBuilder

object UsersTable : AbstractTable<UserEntity>() {
    private const val LOGIN = "login"
    private const val LOGIN_LENGTH = 50
    private const val PASSWORD = "password"
    private const val PASSWORD_LENGTH = 50
    private const val FIRST_NAME = "first_name"
    private const val FIRST_NAME_LENGTH = 50
    private const val SECOND_NAME = "second_name"
    private const val SECOND_NAME_LENGTH = 50

    val login = varchar(LOGIN, length = LOGIN_LENGTH)
    val password = varchar(PASSWORD, length = PASSWORD_LENGTH)
    val firstName = varchar(FIRST_NAME, length = FIRST_NAME_LENGTH)
    val secondName = varchar(SECOND_NAME, length = SECOND_NAME_LENGTH)

    override fun ResultRow.toEntity(): UserEntity = UserEntity(
        login = this[login],
        password = this[password],
        firstName = this[firstName],
        secondName = this[secondName],
        id = this[id].value
    )

    override fun updateStatement(st: UpdateBuilder<Int>, entity: UserEntity) {
        st[login] = entity.login
        st[password] = entity.password
        st[firstName] = entity.firstName
        st[secondName] = entity.secondName
    }
}