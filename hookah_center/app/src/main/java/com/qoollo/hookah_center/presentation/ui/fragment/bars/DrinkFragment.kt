package com.qoollo.hookah_center.presentation.ui.fragment.bars

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.qoollo.hookah_center.presentation.screen.bars.DrinkScreen
import com.qoollo.hookah_center.presentation.ui.theme.HookahCenterTheme
import com.qoollo.hookah_center.presentation.ui.viewModel.bars.DrinkViewModel
import org.koin.android.ext.android.inject
import java.util.UUID

class DrinkFragment : Fragment() {
    private val viewModel: DrinkViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val id = requireArguments().getString("drink_id")
        val uuid = UUID.fromString(id)

        viewModel.setId(uuid)
        return ComposeView(requireContext()).apply {
            setContent {
                HookahCenterTheme {
                    DrinkScreen(viewModel = viewModel)
                }
            }
        }
    }
}