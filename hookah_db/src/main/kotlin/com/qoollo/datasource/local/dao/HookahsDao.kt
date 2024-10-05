package com.qoollo.datasource.local.dao

import com.qoollo.datasource.local.entity.db.HookahEntity
import com.qoollo.datasource.local.table.HookahsTable

abstract class HookahsDao() : BaseCRUDDao<HookahEntity>(HookahsTable) {
}