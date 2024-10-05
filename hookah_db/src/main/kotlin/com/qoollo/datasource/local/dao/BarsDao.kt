package com.qoollo.datasource.local.dao

import com.qoollo.datasource.local.entity.db.BarEntity
import com.qoollo.datasource.local.table.BarsTable

abstract class BarsDao() : BaseCRUDDao<BarEntity>(BarsTable) {
}