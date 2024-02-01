package com.example.anusmaaraka.bottomNavigationScreen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Doorbell
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Interests
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search

val bottomNavItems = listOf<BottomNavItem>(
    BottomNavItem(
        route = Screen.Profile.route,
        contentDescription = "Profile",
        icon = Icons.Default.Person,
//        selectedIcon = R.drawable.ic_solid_home_2
    ),
//    BottomNavItem(
//        route = "sample_screen-2",
//        contentDescription = "Search",
//        icon = Icons.Default.Search,
////        selectedIcon = R.drawable.ic_solid_wallet_2
//    ),
    BottomNavItem(
        route = "-",
    ),
//    BottomNavItem(
//        route = "sample_screen-3",
//        contentDescription = "Notification",
//        icon = Icons.Default.Doorbell,
////        selectedIcon = R.drawable.ic_solid_shield_tick
//    ),
    BottomNavItem(
        route = Screen.InfoDetail.route,
        contentDescription = "Info",
        icon = Icons.Default.Interests,
//        selectedIcon = R.drawable.ic_solid_setting_2
    )
)