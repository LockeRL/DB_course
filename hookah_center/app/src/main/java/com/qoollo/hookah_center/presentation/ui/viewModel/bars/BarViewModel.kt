package com.qoollo.hookah_center.presentation.ui.viewModel.bars

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.qoollo.hookah_center.common.repository.local.ILocalBarsRepository
import com.qoollo.hookah_center.common.repository.local.ILocalDrinksRepository
import com.qoollo.hookah_center.common.repository.local.ILocalFoodRepository
import com.qoollo.hookah_center.common.repository.local.ILocalHookahsRepository
import com.qoollo.hookah_center.common.repository.remote.IRemoteBarsRepository
import com.qoollo.hookah_center.domain.model.Drink
import com.qoollo.hookah_center.domain.model.Food
import com.qoollo.hookah_center.domain.model.Hookah
import com.qoollo.hookah_center.presentation.mapper.toViewData
import com.qoollo.hookah_center.presentation.model.BarViewData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.UUID

class BarViewModel(
    private val localBarRep: ILocalBarsRepository
) : ViewModel() {
    private val _idState = MutableStateFlow<UUID?>(null)

    val bar: StateFlow<BarViewData?> = _idState.filterNotNull().flatMapLatest { id ->
        localBarRep.read(id).map { bar -> bar?.toViewData() }
    }.stateIn(viewModelScope, SharingStarted.Eagerly, null)

    fun setId(id: UUID) {
        _idState.value = id
    }
}