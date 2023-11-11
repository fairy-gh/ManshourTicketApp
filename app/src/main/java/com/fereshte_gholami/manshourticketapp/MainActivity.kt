package com.fereshte_gholami.manshourticketapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fereshte_gholami.manshourticketapp.ui.HomeScreen
import com.fereshte_gholami.manshourticketapp.ui.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = getString(R.string.home)
            ) {
                composable(route = getString(R.string.home)) {
                    val viewModel = hiltViewModel<HomeViewModel>()
                    HomeScreen(
                        viewModel
                    )
                }
            }
        }
    }
}