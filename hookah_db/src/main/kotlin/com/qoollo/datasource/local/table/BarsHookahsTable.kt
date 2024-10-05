package com.qoollo.datasource.local.table

import com.qoollo.datasource.local.entity.db.BarHookahEntity
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.statements.UpdateBuilder

object BarsHookahsTable : AbstractTable<BarHookahEntity>() {
    private const val BAR_ID = "bar_id"
    private const val HOOKAH_ID = "hookah_id"
    private const val PRICE = "price"

    val barId = reference(BAR_ID, BarsTable.id, onDelete = ReferenceOption.CASCADE)
    val hookahId = reference(HOOKAH_ID, HookahsTable.id, onDelete = ReferenceOption.CASCADE)
    val price = double(PRICE)

    override fun ResultRow.toEntity(): BarHookahEntity = BarHookahEntity(
        barId = this[barId].value,
        hookahId = this[hookahId].value,
        price = this[price],
        id = this[id].value
    )

    override fun updateStatement(st: UpdateBuilder<Int>, entity: BarHookahEntity) {
        st[barId] = entity.barId
        st[hookahId] = entity.hookahId
        st[price] = entity.price
    }
}