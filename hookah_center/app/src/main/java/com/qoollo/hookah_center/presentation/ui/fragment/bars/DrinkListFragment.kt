package com.qoollo.hookah_center.presentation.ui.fragment.bars

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.qoollo.hookah_center.R
import com.qoollo.hookah_center.presentation.screen.bars.DrinkListScreen
import com.qoollo.hookah_center.presentation.ui.theme.HookahCenterTheme
import com.qoollo.hookah_center.presentation.ui.viewModel.bars.DrinkListViewModel
import org.koin.android.ext.android.inject
import java.util.UUID

class DrinkListFragment : Fragment() {
    private val viewModel: DrinkListViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val id = requireArguments().getString("bar_id")
        val uuid = UUID.fromString(id)
        viewModel.setId(uuid)

        val controller = findNavController()
        return ComposeView(requireContext()).apply {
            setContent {
                HookahCenterTheme {
                    DrinkListScreen(viewModel = viewModel) { id ->
                        controller.navigate(
                            resId = R.id.action_drinkListFragment_to_drinkFragment,
                            args = Bundle().apply { putString("drink_id", id.toString()) }
                        )
                    }
                }
            }
        }
    }
}