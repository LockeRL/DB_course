package com.qoollo.hookah_center.presentation.ui.fragment.bars

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.qoollo.hookah_center.R
import com.qoollo.hookah_center.presentation.screen.bars.HookahListScreen
import com.qoollo.hookah_center.presentation.ui.theme.HookahCenterTheme
import com.qoollo.hookah_center.presentation.ui.viewModel.bars.HookahListViewModel
import org.koin.android.ext.android.inject
import java.util.UUID

class HookahListFragment : Fragment() {
    private val viewModel: HookahListViewModel by inject()

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
                    HookahListScreen(viewModel = viewModel) { id ->
                        controller.navigate(
                            resId = R.id.action_hookahListFragment_to_hookahFragment,
                            args = Bundle().apply { putString("hookah_id", id.toString()) }
                        )
                    }
                }
            }
        }
    }
}