package com.qoollo.hookah_center.presentation.ui.fragment.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.qoollo.hookah_center.R
import com.qoollo.hookah_center.presentation.screen.profile.LoginScreen
import com.qoollo.hookah_center.presentation.ui.viewModel.profile.LoginViewModel
import com.qoollo.hookah_center.presentation.ui.states.LoginUiState
import com.qoollo.hookah_center.presentation.ui.theme.HookahCenterTheme
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {
    private val viewModel by viewModel<LoginViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val controller = findNavController()

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.uiState.collect { state ->
                println(state)
                when (state) {
                    is LoginUiState.Success -> controller.navigate(R.id.action_loginFragment_to_profileFragment)
                    is LoginUiState.Error -> println(state.error)
                    is LoginUiState.Loading -> {}
                    is LoginUiState.Idle -> {}
                }
            }
        }

        return ComposeView(requireContext()).apply {
            setContent {
                HookahCenterTheme {
                    LoginScreen(viewModel = viewModel)
                }
            }
        }
    }
}