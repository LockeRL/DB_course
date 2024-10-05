package com.qoollo.domain.repository

import com.qoollo.domain.model.db.Org
import java.util.*

interface IOrganizationsRepository {
    suspend fun insertOrg(org: Org): UUID
    suspend fun updateOrg(orgId: UUID, org: Org)
    suspend fun deleteOrg(orgId: UUID)
}