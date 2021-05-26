package com.example.blogapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.blogapp.core.hide
import com.example.blogapp.core.show
import com.example.blogapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        navController = navHostFragment.navController

        binding.bottomNavigationView.setupWithNavController(navController)

        observerDestinationChange()
    }

    private fun observerDestinationChange(){
        navController.addOnDestinationChangedListener {controller, destination, arguments ->
            when(destination.id){
                R.id.loginFragment -> {
                    binding.bottomNavigationView.hide()

                }

                R.id.registerFragment ->{
                    binding.bottomNavigationView.hide()
                }

                else -> {
                    binding.bottomNavigationView.show()
                }
            }
        }
    }
}