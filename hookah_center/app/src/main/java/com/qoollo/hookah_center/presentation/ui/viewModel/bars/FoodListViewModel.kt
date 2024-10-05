package com.qoollo.hookah_center.presentation.ui.viewModel.bars

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.qoollo.hookah_center.common.repository.local.ILocalFoodRepository
import com.qoollo.hookah_center.common.repository.remote.IRemoteBarsRepository
import com.qoollo.hookah_center.domain.model.Food
import com.qoollo.hookah_center.presentation.mapper.toViewData
import com.qoollo.hookah_center.presentation.model.FoodViewData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.UUID

class FoodListViewModel(
    private val localFoodRepository: ILocalFoodRepository,
    private val remoteFoodRepository: IRemoteBarsRepository
) : ViewModel() {
    val food: StateFlow<List<FoodViewData>> = localFoodRepository.read().map { list ->
        list.map { food -> food.toViewData() }
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
                remoteFoodRepository.getFood(_id.value!!)
                    .onSuccess { food ->
                        localFoodRepository.insert(food)
                    }
                isRefreshing = false
            }
        }
    }

    private fun initData(id: UUID) {
        viewModelScope.launch(Dispatchers.IO) {
            val food = Food(
                id = UUID.randomUUID(),
                name = "soup",
                ingredients = "voda",
                price = 800.0
            )
            localFoodRepository.insert(
                listOf(
                    food,
                    food.copy(id = UUID.randomUUID(), name = "meat")
                )
            )
            dataLoaded = true
//            remoteFoodRepository.getFood(id)
//                .onSuccess { food ->
//                    localFoodRepository.insert(food)
//                    dataLoaded = true
//                }
        }
    }
}