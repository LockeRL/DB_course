package com.qoollo.hookah_center.presentation.ui.viewModel.bars

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.qoollo.hookah_center.common.repository.local.ILocalDrinksRepository
import com.qoollo.hookah_center.common.repository.remote.IRemoteBarsRepository
import com.qoollo.hookah_center.domain.model.Drink
import com.qoollo.hookah_center.domain.model.Food
import com.qoollo.hookah_center.presentation.mapper.toViewData
import com.qoollo.hookah_center.presentation.model.DrinkViewData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.UUID

class DrinkListViewModel(
    private val localDrinkRep: ILocalDrinksRepository,
    private val remoteDrinkRep: IRemoteBarsRepository
) : ViewModel() {
    val drinks: StateFlow<List<DrinkViewData>> = localDrinkRep.read().map { list ->
        list.map { drink -> drink.toViewData() }
    }.stateIn(viewModelScope, SharingStarted.Eagerly, listOf())

    private val _id: MutableState<UUID?> = mutableStateOf(null)

    var dataLoaded by mutableStateOf(false)
        private set

    var isRefreshing by mutableStateOf(false)
        private set

    fun setId(id: UUID) {
        _id.value = id
        initData(id)
    }

    fun refresh() {
        val id = _id.value
        if (id != null) {
            isRefreshing = dataLoaded
            viewModelScope.launch(Dispatchers.IO) {
                remoteDrinkRep.getDrinks(_id.value!!)
                    .onSuccess { drinks ->
                        localDrinkRep.insert(drinks)
                    }
                isRefreshing = false
            }
        }
    }

    private fun initData(id: UUID) {
        viewModelScope.launch(Dispatchers.IO) {
            val drink = Drink(
                id = UUID.randomUUID(),
                name = "super voda",
                ingredients = "voda",
                type = "non alcohol",
                price = 400.0
            )
            localDrinkRep.insert(
                listOf(
                    drink,
                    drink.copy(id = UUID.randomUUID(), name = "sok")
                )
            )
            dataLoaded = true
//            remoteDrinkRep.getDrinks(id)
//                .onSuccess { drinks ->
//                    localDrinkRep.insert(drinks)
//                    dataLoaded = true
//                }
        }
    }
}