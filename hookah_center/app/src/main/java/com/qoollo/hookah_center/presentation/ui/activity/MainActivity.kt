package com.qoollo.hookah_center.presentation.ui.activity

import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.qoollo.hookah_center.R
import com.qoollo.hookah_center.databinding.ActivityMainBinding
import com.qoollo.hookah_center.presentation.ui.viewModel.NavigationViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val navGraphViewModel: NavigationViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigationView: BottomNavigationView = binding.bottomNav

        val controller = binding.containerView.getFragment<NavHostFragment>().navController

        bottomNavigationView.findViewById<View>(R.id.home).setOnClickListener {
            controller.navigate(R.id.action_global_barsContainerFragment)
        }

        bottomNavigationView.findViewById<View>(R.id.profile).setOnClickListener {
            controller.navigate(R.id.action_global_profileContainerFragment)
        }

        controller.addOnDestinationChangedListener { _, destination, _ ->
            val selectedId = destination.hierarchy.mapNotNull {
                when (it.id) {
                    R.id.barsContainerFragment -> R.id.home
                    R.id.profileContainerFragment -> R.id.profile
                    else -> null
                }
            }.firstOrNull()

            if (selectedId != null)
                bottomNavigationView.selectedItemId = selectedId
        }

        onBackPressedDispatcher.addCallback(this) {
            navGraphViewModel.submitNestedMultiStackBackEvent()
        }

        navGraphViewModel.bottomNavBackEvent
            .onEach {
                controller.popBackStack()
            }.flowWithLifecycle(lifecycle)
            .launchIn(lifecycleScope)

    }
}