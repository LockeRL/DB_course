package com.qoollo.hookah_center.presentation.ui.fragment.bars

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.Text
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.qoollo.hookah_center.presentation.screen.bars.HookahScreen
import com.qoollo.hookah_center.presentation.ui.theme.HookahCenterTheme
import com.qoollo.hookah_center.presentation.ui.viewModel.bars.HookahViewModel
import org.koin.android.ext.android.inject
import java.util.UUID

class HookahFragment : Fragment() {
    private val viewModel: HookahViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val id = requireArguments().getString("hookah_id")
        val uuid = UUID.fromString(id)

        viewModel.setId(uuid)
        return ComposeView(requireContext()).apply {
            setContent {
                HookahCenterTheme {
                    HookahScreen(viewModel = viewModel)
                }
            }
        }
    }
}