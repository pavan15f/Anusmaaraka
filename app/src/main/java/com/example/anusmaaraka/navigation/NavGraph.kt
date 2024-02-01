package com.example.anusmaaraka.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.anusmaaraka.bottomNavigationScreen.Screen

@Preview
@Composable
fun NavGraph() {
    val navController = rememberNavController()
    val actions = remember(navController) { MainActions(navController) }

    NavHost(navController, startDestination = Screen.Splash.route) {

        //Splash Screen
        composable(Screen.Splash.route) {
//            SplashScreenView(actions)
        }

        //OnBoarding Screen
        composable(Screen.Profile.route) {
//            OnBoardingScreenView(actions)
        }

        //Dashboard
        composable(Screen.Upcoming.route) {

        }

        //Vegetable Detail
        composable(Screen.InfoDetail.route) {
//            VegetableDetail(actions)
        }
    }
}

class MainActions(private val navController: NavHostController) {

    val popBackStack: () -> Unit = {
        navController.popBackStack()
    }

    val upPress: () -> Unit = {
        navController.navigateUp()
    }

    val gotoOnBoarding: () -> Unit = {
        navController.popBackStack()
        navController.navigate(Screen.Profile.route)
    }

    val gotoOnDashboard: () -> Unit = {
        navController.popBackStack()
        navController.navigate(Screen.Upcoming.route)
    }

    val gotoVegetableDetail: () -> Unit = {
        navController.navigate(Screen.InfoDetail.route)
    }
}