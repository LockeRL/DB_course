package com.qoollo.hookah_center.presentation.ui.fragment.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.qoollo.hookah_center.presentation.screen.profile.ProfileScreen
import com.qoollo.hookah_center.presentation.ui.theme.HookahCenterTheme
import com.qoollo.hookah_center.presentation.ui.viewModel.profile.ProfileViewModel
import org.koin.android.ext.android.inject

class ProfileFragment : Fragment() {
    private val viewModel: ProfileViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent { 
                HookahCenterTheme {
                    ProfileScreen(viewModel)
                }
            }
        }
    }
}