package com.qoollo.hookah_center.presentation.ui.viewModel.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.qoollo.hookah_center.common.repository.local.ILocalOwnerRepository
import com.qoollo.hookah_center.common.repository.local.ILocalUsersRepository
import com.qoollo.hookah_center.domain.model.Owner
import com.qoollo.hookah_center.presentation.mapper.toViewData
import com.qoollo.hookah_center.presentation.model.OwnerViewData
import com.qoollo.hookah_center.presentation.model.UserInfoViewData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import java.util.UUID

class ProfileViewModel(
    ownerRep: ILocalOwnerRepository
) : ViewModel() {

    val ownerFlow: StateFlow<OwnerViewData?> =
        ownerRep.read()
            .map { owner -> owner?.toViewData() }
            .stateIn(viewModelScope, SharingStarted.Eagerly, null)
}