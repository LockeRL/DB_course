package com.qoollo.hookah_center.presentation.ui.viewModel.bars

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.qoollo.hookah_center.common.repository.local.ILocalBarsRepository
import com.qoollo.hookah_center.common.repository.remote.IRemoteBarsRepository
import com.qoollo.hookah_center.domain.model.Bar
import com.qoollo.hookah_center.presentation.mapper.toViewData
import com.qoollo.hookah_center.presentation.model.BarViewData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.UUID

class BarListViewModel(
    private val localBarsRep: ILocalBarsRepository,
    private val remoteBarsRep: IRemoteBarsRepository
) : ViewModel() {
    val bars: StateFlow<List<BarViewData>> =
        localBarsRep.read().map { list ->
            list.map { bar ->
                bar.toViewData()
            }
        }
            .stateIn(viewModelScope, SharingStarted.Eagerly, listOf())

    var dataLoaded by mutableStateOf(false)
        private set

    var isRefreshing by mutableStateOf(false)
        private set

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val bar = Bar(
                id = UUID.randomUUID(),
                score = 4.5f,
                name = "myata",
                phone = "3274682",
                website = "myata.ru",
                city = "moscow",
                latitude = 213.3,
                longitude = 333.2,
                schedule = ""
            )
            localBarsRep.insert(
                listOf(
                    bar,
                    bar.copy(id = UUID.randomUUID(), name = "arya")
                )
            )
            dataLoaded = true
//            remoteBarsRep.getBars()
//                .onSuccess { bars ->
//                    localBarsRep.insert(bars)
//                    dataLoaded = true
//                }
        }
    }

    fun refresh() {
        isRefreshing = dataLoaded
        viewModelScope.launch(Dispatchers.IO) {
            remoteBarsRep.getBars()
                .onSuccess { bars ->
                    localBarsRep.insert(bars)
                }
            isRefreshing = false
        }
    }
}