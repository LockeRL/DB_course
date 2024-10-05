package com.qoollo.data.repository

import com.qoollo.data.datasource.local.service.IOrganizationsDaoService
import com.qoollo.domain.model.db.Org
import com.qoollo.domain.repository.IOrganizationsRepository
import java.util.*

class OrganizationsRepository(private val orgService: IOrganizationsDaoService) : IOrganizationsRepository {
    override suspend fun insertOrg(org: Org): UUID = orgService.insert(org)

    override suspend fun updateOrg(orgId: UUID, org: Org) = orgService.update(orgId, org)

    override suspend fun deleteOrg(orgId: UUID) = orgService.delete(orgId)
}