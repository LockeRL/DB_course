package com.qoollo.datasource.local.dao

import com.qoollo.datasource.local.entity.db.FoodEntity
import com.qoollo.datasource.local.table.FoodTable

abstract class FoodDao() : BaseCRUDDao<FoodEntity>(FoodTable) {
}