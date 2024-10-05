package com.qoollo.hookah_center.presentation.ui.fragment.bars

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.Text
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import com.qoollo.hookah_center.R
import com.qoollo.hookah_center.databinding.FragmentBarsContainerBinding
import com.qoollo.hookah_center.databinding.FragmentProfileContainerBinding
import com.qoollo.hookah_center.presentation.ui.theme.HookahCenterTheme
import com.qoollo.hookah_center.presentation.ui.viewModel.NavigationViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.activityViewModel

class BarsContainerFragment : Fragment() {
    private var _binding: FragmentBarsContainerBinding? = null
    private val binding: FragmentBarsContainerBinding
        get() = _binding!!

    private val navGraphViewModel: NavigationViewModel by activityViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBarsContainerBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navGraphViewModel.nestedMultiStackBackEvent
            .onEach {
                val navController = binding.barsContainer.getFragment<NavHostFragment>().navController
                if (navController.previousBackStackEntry != null)
                    navController.popBackStack()
                else
                    navGraphViewModel.submitButtonNavEvent()
            }.flowWithLifecycle(viewLifecycleOwner.lifecycle)
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}