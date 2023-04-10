package com.enigmacamp.livecodegoldmarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.enigmacamp.livecodegoldmarket.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var bundle = Bundle()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.findNavController()

        navController.addOnDestinationChangedListener{_, destination, _ ->
            when(destination.id) {
                R.id.profileFragment, R.id.historyFragment, R.id.homeFragment -> {
                    binding.bottomNavigation.visibility = View.VISIBLE
                }
                else -> {binding.bottomNavigation.visibility = View.GONE}
            }
        }

        binding.bottomNavigation.setOnItemSelectedListener{
            when(it.itemId) {
                R.id.homeMenuFragment -> {
                    navController.navigate(
                        R.id.homeFragment,
                        bundle,
                        NavOptions.Builder().setPopUpTo(
                            R.id.nav_graph,
                            true
                        ).build()
                    )
                    true
                }
                R.id.historyMenuFragment -> {
                    navController.navigate(
                        R.id.historyFragment,
                        bundle,
                        NavOptions.Builder().setPopUpTo(R.id.nav_graph, true).build()
                    )
                    true
                }
                R.id.profileMenuFragment -> {
                    navController.navigate(
                        R.id.profileFragment,
                        bundle,
                        NavOptions.Builder().setPopUpTo(R.id.nav_graph, true).build()
                    )
                    true
                }
                else -> false
            }
        }
    }
}