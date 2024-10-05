package com.qoollo.datasource.local.table

import com.qoollo.datasource.local.entity.db.BarEntity
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.statements.UpdateBuilder

object BarsTable : AbstractTable<BarEntity>() {
    private const val ORG_ID = "org_id"
    private const val NAME = "name"
    private const val NAME_LENGTH = 50
    private const val PHONE = "phone"
    private const val PHONE_LENGTH = 20
    private const val WEBSITE = "website"
    private const val WEBSITE_LENGTH = 50
    private const val CITY = "city"
    private const val CITY_LENGTH = 50
    private const val LATITUDE = "latitude"
    private const val LONGITUDE = "longitude"
    private const val SCHEDULE = "schedule"

    val orgId = reference(ORG_ID, OrganizationsTable.id, onDelete = ReferenceOption.CASCADE)
    val name = varchar(NAME, length = NAME_LENGTH)
    val phone = varchar(PHONE, length = PHONE_LENGTH)
    val website = varchar(WEBSITE, length = WEBSITE_LENGTH)
    val city = varchar(CITY, length = CITY_LENGTH)
    val latitude = double(LATITUDE)
    val longitude = double(LONGITUDE)
    val schedule = text(SCHEDULE)

    override fun ResultRow.toEntity(): BarEntity = BarEntity(
        name = this[name],
        phone = this[phone],
        website = this[website],
        city = this[city],
        latitude = this[latitude],
        longitude = this[longitude],
        schedule = this[schedule],
        orgId = this[orgId].value,
        id = this[id].value
    )

    override fun updateStatement(st: UpdateBuilder<Int>, entity: BarEntity) {
        st[orgId] = entity.orgId
        st[name] = entity.name
        st[phone] = entity.phone
        st[website] = entity.website
        st[city] = entity.city
        st[latitude] = entity.latitude
        st[longitude] = entity.longitude
        st[schedule] = entity.schedule
    }
}