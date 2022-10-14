package com.example.trivia.views

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.example.trivia.R
import com.example.trivia.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        val navHost =  supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        val navController = navHost.navController

        //appBarConfiguration = AppBarConfiguration(setOf(R.id.mainFragment3,R.id.gameFragment))

        setupActionBarWithNavController(navController)

        //binding.toolBar.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {

        return findNavController(R.id.fragment_container).navigateUp(appBarConfiguration)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = findNavController(R.id.fragment_container)
        return item.onNavDestinationSelected(navController) ||
                super.onOptionsItemSelected(item)
    }
}