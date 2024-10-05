package com.qoollo.hookah_center.presentation.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class NavigationViewModel : ViewModel() {
    private val _nestedMultiStackBackEvent: MutableSharedFlow<Unit> = MutableSharedFlow()
    val nestedMultiStackBackEvent: SharedFlow<Unit> = _nestedMultiStackBackEvent

    private val _bottomNavBackEvent: MutableSharedFlow<Unit> = MutableSharedFlow()
    val bottomNavBackEvent: SharedFlow<Unit> = _bottomNavBackEvent

    fun submitNestedMultiStackBackEvent() {
        viewModelScope.launch {
            _nestedMultiStackBackEvent.emit(Unit)
        }
    }

    fun submitButtonNavEvent() {
        viewModelScope.launch {
            _bottomNavBackEvent.emit(Unit)
        }
    }
}