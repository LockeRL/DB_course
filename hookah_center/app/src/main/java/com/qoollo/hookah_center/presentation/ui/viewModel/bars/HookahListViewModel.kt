package com.qoollo.hookah_center.presentation.ui.viewModel.bars

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.qoollo.hookah_center.common.repository.local.ILocalHookahsRepository
import com.qoollo.hookah_center.common.repository.remote.IRemoteBarsRepository
import com.qoollo.hookah_center.domain.model.Food
import com.qoollo.hookah_center.domain.model.Hookah
import com.qoollo.hookah_center.presentation.mapper.toViewData
import com.qoollo.hookah_center.presentation.model.HookahViewData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.UUID

class HookahListViewModel(
    private val localHookahRep: ILocalHookahsRepository,
    private val remoteHookahRep: IRemoteBarsRepository
) : ViewModel() {
    val hookahs: StateFlow<List<HookahViewData>> = localHookahRep.read().map { list ->
        list.map { hookah -> hookah.toViewData() }
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
                remoteHookahRep.getHookahs(_id.value!!)
                    .onSuccess { hookahs ->
                        localHookahRep.insert(hookahs)
                    }
                isRefreshing = false
            }
        }
    }

    private fun initData(id: UUID) {
        viewModelScope.launch(Dispatchers.IO) {
            val hookah = Hookah(
                id = UUID.randomUUID(),
                name = "mandarin",
                description = "tabak krutoi",
                type = "ceylon",
                price = 400.0
            )
            localHookahRep.insert(
                listOf(
                    hookah,
                    hookah.copy(id = UUID.randomUUID(), name = "morozhenoe")
                )
            )
            dataLoaded = true
//            remoteHookahRep.getHookahs(id)
//                .onSuccess { hookahs ->
//                    localHookahRep.insert(hookahs)
//                    dataLoaded = true
//                }
        }
    }
}