package com.example.anusmaaraka.bottomNavigationScreen

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.anusmaaraka.view.InfoDetailView
import com.example.anusmaaraka.view.UpcomingContent
import com.example.anusmaaraka.view.ProfileView

@ExperimentalMaterialApi
@Composable
fun BottomNavigationScreen() {
    Surface(color = MaterialTheme.colors.background) {
        val navController = rememberNavController()
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        StandardScaffold(
            bottomNavItems = bottomNavItems,
            navController = navController,
//            showBottomBar = shouldShowBottomBar(navBackStackEntry)
        ) {
//            Navigation(navController = navController)
            NavHost(navController = navController, startDestination = Screen.Upcoming.route ) {
                composable(route = Screen.Profile.route) {
                    ProfileView()
                }
                composable(route = Screen.Upcoming.route) {
                    UpcomingContent()
                }
                composable(route = Screen.InfoDetail.route) {
                    InfoDetailView()
                }
            }
        }
    }
}