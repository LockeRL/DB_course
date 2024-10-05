package com.qoollo.hookah_center.presentation.ui.fragment.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import com.qoollo.hookah_center.databinding.FragmentProfileContainerBinding
import com.qoollo.hookah_center.presentation.ui.viewModel.NavigationViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.activityViewModel

class ProfileContainerFragment : Fragment() {
    private var _binding: FragmentProfileContainerBinding? = null
    private val binding: FragmentProfileContainerBinding
        get() = _binding!!

    private val navGraphViewModel: NavigationViewModel by activityViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileContainerBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navGraphViewModel.nestedMultiStackBackEvent
            .onEach {
                val navController = binding.profileContainer.getFragment<NavHostFragment>().navController
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