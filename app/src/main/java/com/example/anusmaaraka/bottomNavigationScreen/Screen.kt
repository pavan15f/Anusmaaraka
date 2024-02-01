package com.example.anusmaaraka.bottomNavigationScreen

import androidx.annotation.StringRes
import com.example.anusmaaraka.R

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object Splash : Screen("Splash", R.string.splash)
    object Profile : Screen("Profile", R.string.profile)
    object Upcoming : Screen("Upcoming", R.string.upcoming)
    object InfoDetail : Screen("Info", R.string.info)

}