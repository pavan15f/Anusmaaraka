package com.example.anusmaaraka

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.anusmaaraka.navigation.MainActions
import com.example.anusmaaraka.bottomNavigationScreen.Screen
import com.example.anusmaaraka.sampleData.TestSampleDataProvider
import com.example.anusmaaraka.ui.theme.AnusmaarakaTheme
import com.example.anusmaaraka.view.InfoDetailView
import com.example.anusmaaraka.view.ProfileView
import com.example.anusmaaraka.view.UpcomingContent
import com.example.anusmaaraka.view.UpcomingScreenView


data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)

class UpcomingActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var dateList = TestSampleDataProvider().getSampleData()


        setContent {
            AnusmaarakaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFffffff)
                ) {
                    UpcomingActivityView()
                }
            }
        }
    }

}

@Preview
@Composable
fun UpcomingActivityView(){
     OverviewScreen()
}

@Composable
fun OverviewScreen() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column( modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceEvenly
        ){
            NavigationView()
        }
    }
}





@Composable
fun NavigationView(){

    val navController = rememberNavController()
    val actions = remember(navController) { MainActions(navController) }

    SetupNavGraph(navController)
    UpcomingScreenView(navController)

}

@Composable
private fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.Splash.route) {

        //Splash Screen
        composable(Screen.Splash.route) {
//            SplashScreenView(actions)
        }

        //OnBoarding Screen
        composable(Screen.Profile.route) {
            ProfileView()
        }

        //Dashboard
        composable(Screen.Upcoming.route) {
            UpcomingContent()
        }

        //Vegetable Detail
        composable(Screen.InfoDetail.route) {
            InfoDetailView()
        }
    }
}




