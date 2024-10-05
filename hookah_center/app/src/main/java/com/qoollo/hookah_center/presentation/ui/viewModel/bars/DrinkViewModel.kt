package com.qoollo.hookah_center.presentation.ui.viewModel.bars

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.qoollo.hookah_center.common.repository.local.ILocalDrinksRepository
import com.qoollo.hookah_center.presentation.mapper.toViewData
import com.qoollo.hookah_center.presentation.model.DrinkViewData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import java.util.UUID

class DrinkViewModel(
    localDrinkRep: ILocalDrinksRepository
) : ViewModel() {
    private val _id = MutableStateFlow<UUID?>(null)

    val drink: StateFlow<DrinkViewData?> = _id.filterNotNull().flatMapLatest { id ->
        localDrinkRep.read(id).map { drink -> drink?.toViewData() }
    }.stateIn(viewModelScope, SharingStarted.Eagerly, null)

    fun setId(id: UUID) {
        _id.value = id
    }
}