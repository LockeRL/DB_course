package com.qoollo.datasource.local.dao

import com.qoollo.datasource.local.entity.db.DrinkEntity
import com.qoollo.datasource.local.table.DrinksTable

abstract class DrinksDao() : BaseCRUDDao<DrinkEntity>(DrinksTable) {
}