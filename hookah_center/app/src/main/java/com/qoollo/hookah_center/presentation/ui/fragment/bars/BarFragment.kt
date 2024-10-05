package com.qoollo.hookah_center.presentation.ui.fragment.bars

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.qoollo.hookah_center.R
import com.qoollo.hookah_center.presentation.screen.bars.BarScreen
import com.qoollo.hookah_center.presentation.ui.theme.HookahCenterTheme
import com.qoollo.hookah_center.presentation.ui.viewModel.bars.BarViewModel
import org.koin.android.ext.android.inject
import java.util.UUID

class BarFragment : Fragment() {
    val viewModel: BarViewModel by inject()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val id = requireArguments().getString("bar_id")
        val uuid = UUID.fromString(id)
        viewModel.setId(uuid)

        val controller = findNavController()
        val args = Bundle().apply { putString("bar_id", id) }
        return ComposeView(requireContext()).apply {
            setContent {
                HookahCenterTheme {
                    BarScreen(
                        viewModel = viewModel,
                        onClickNavigateFood = {
                            controller.navigate(
                                resId = R.id.action_barFragment_to_foodListFragment,
                                args = args
                            )
                        },
                        onClickNavigateHookahs = {
                            controller.navigate(
                                resId = R.id.action_barFragment_to_hookahListFragment,
                                args = args
                            )
                        },
                        onClickNavigateDrinks = {
                            controller.navigate(
                                resId = R.id.action_barFragment_to_drinkListFragment,
                                args = args
                            )
                        }
                    )
                }
            }
        }
    }
}