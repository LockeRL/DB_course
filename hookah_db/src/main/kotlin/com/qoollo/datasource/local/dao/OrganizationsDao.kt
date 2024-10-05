package com.qoollo.datasource.local.dao

import com.qoollo.datasource.local.entity.db.OrgEntity
import com.qoollo.datasource.local.table.OrganizationsTable

abstract class OrganizationsDao() : BaseCRUDDao<OrgEntity>(OrganizationsTable) {
}