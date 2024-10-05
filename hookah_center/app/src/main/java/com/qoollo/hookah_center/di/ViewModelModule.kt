package com.qoollo.hookah_center.di

import com.qoollo.hookah_center.presentation.ui.viewModel.bars.BarListViewModel
import com.qoollo.hookah_center.presentation.ui.viewModel.bars.BarViewModel
import com.qoollo.hookah_center.presentation.ui.viewModel.bars.DrinkListViewModel
import com.qoollo.hookah_center.presentation.ui.viewModel.bars.DrinkViewModel
import com.qoollo.hookah_center.presentation.ui.viewModel.bars.FoodListViewModel
import com.qoollo.hookah_center.presentation.ui.viewModel.bars.HookahListViewModel
import com.qoollo.hookah_center.presentation.ui.viewModel.profile.LoginViewModel
import com.qoollo.hookah_center.presentation.ui.viewModel.NavigationViewModel
import com.qoollo.hookah_center.presentation.ui.viewModel.bars.FoodViewModel
import com.qoollo.hookah_center.presentation.ui.viewModel.bars.HookahViewModel
import com.qoollo.hookah_center.presentation.ui.viewModel.profile.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { LoginViewModel(get(), get()) }
    viewModel { NavigationViewModel() }
    viewModel { ProfileViewModel(get()) }
    viewModel { BarListViewModel(get(), get()) }
    viewModel { BarViewModel(get()) }
    viewModel { FoodListViewModel(get(), get()) }
    viewModel { HookahListViewModel(get(), get()) }
    viewModel { DrinkListViewModel(get(), get()) }
    viewModel { DrinkViewModel(get()) }
    viewModel { HookahViewModel(get()) }
    viewModel { FoodViewModel(get()) }
}