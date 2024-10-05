package com.qoollo.hookah_center.presentation.ui.fragment.bars

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.qoollo.hookah_center.R
import com.qoollo.hookah_center.presentation.screen.bars.BarListScreen
import com.qoollo.hookah_center.presentation.ui.theme.HookahCenterTheme
import com.qoollo.hookah_center.presentation.ui.viewModel.bars.BarListViewModel
import org.koin.android.ext.android.inject

class BarListFragment : Fragment() {
    private val viewModel: BarListViewModel by inject()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val controller = findNavController()

        return ComposeView(requireContext()).apply {
            setContent {
                HookahCenterTheme {
                    BarListScreen(
                        viewModel = viewModel,
                        onCardClickNavigate = { barId ->
                            controller.navigate(
                                resId = R.id.action_barsFragment_to_barFragment,
                                args = Bundle().apply { putString("bar_id", barId.toString()) }
                            )
                        }
                    )
                }
            }
        }
    }
}