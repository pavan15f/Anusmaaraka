package com.example.anusmaaraka.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.anusmaaraka.BottomNavigationItem
import com.example.anusmaaraka.R
import com.example.anusmaaraka.navigation.MainActions
import com.example.anusmaaraka.bottomNavigationScreen.Screen
import com.example.anusmaaraka.sampleData.TestSampleDataProvider
import com.example.anusmaaraka.ui.theme.AnusmaarakaTheme
import com.example.anusmaaraka.ui.theme.ThemeColor
import com.example.anusmaaraka.ui.theme.black
import com.example.anusmaaraka.ui.theme.lightBlue

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PreviewScreen() {

    val navController = rememberNavController()

    val actions = remember(navController) { MainActions(navController) }

    UpcomingScreenView(navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpcomingScreenView(navController: NavController){
    AnusmaarakaTheme {
        val items = listOf(
            BottomNavigationItem(
                title = Screen.Profile.route,
                selectedIcon = Icons.Filled.Home,
                unselectedIcon = Icons.Outlined.Home,
                hasNews = false,
            ),
            BottomNavigationItem(
                title = Screen.Upcoming.route,
                selectedIcon = Icons.Filled.Email,
                unselectedIcon = Icons.Outlined.Email,
                hasNews = false,
                badgeCount = 45
            ),
            BottomNavigationItem(
                title = Screen.InfoDetail.route,
                selectedIcon = Icons.Filled.Settings,
                unselectedIcon = Icons.Outlined.Settings,
                hasNews = true,
            ),
        )
        var selectedItemIndex by rememberSaveable {
            mutableStateOf(0)
        }
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Scaffold(
                bottomBar = {
                    NavigationBar {
                        items.forEachIndexed { index, item ->
                            NavigationBarItem(
                                selected = selectedItemIndex == index,
                                onClick = {
                                    selectedItemIndex = index
                                    navController.navigate(item.title)
                                },
                                label = {
                                    Text(text = item.title)
                                },
                                alwaysShowLabel = true,
                                icon = {
                                    BadgedBox(
                                        badge = {
                                            if(item.badgeCount != null) {
                                                Badge {
                                                    Text(text = item.badgeCount.toString())
                                                }
                                            } else if(item.hasNews) {
                                                Badge()
                                            }
                                        }
                                    ) {
                                        Icon(
                                            imageVector = if (index == selectedItemIndex) {
                                                item.selectedIcon
                                            } else item.unselectedIcon,
                                            contentDescription = item.title
                                        )
                                    }
                                }
                            )
                        }
                    }
                }
            ) { padding ->
//                Spacer(modifier = Modifier.padding(padding))
//                UpcomingContent()
            }
        }
    }
}

@Preview
@Composable
fun UpcomingContent() {
    Column(verticalArrangement = Arrangement.Top) {
        TopBarAnimationView()
        CommonReminderView()
    }

}

@Composable
fun TopBarAnimationView() {
    Surface(modifier = Modifier
        .fillMaxWidth()
        .background(ThemeColor),
    ){
        Column(modifier = Modifier.padding(24.dp)) {
            Row(modifier = Modifier.align(Alignment.Start), Arrangement.SpaceBetween) {
                Text(
                    text = "Samvatsar : ",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Black,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Normal
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Something",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Normal)
            }
            Row(modifier = Modifier.align(Alignment.Start), Arrangement.SpaceBetween) {
                Text(
                    text = "Date : ",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Black,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Normal
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Something",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Normal)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Image(painter = painterResource(id = R.drawable.red_capsicum), contentDescription = null, modifier = Modifier.align(
                Alignment.CenterHorizontally))
        }


    }
}

@Composable
fun CommonReminderView() {
    Surface(modifier = Modifier
        .fillMaxWidth(),
        color = lightBlue,
        shape = RoundedCornerShape(24.dp,24.dp,0.dp,0.dp)
    ){

        val dateList = TestSampleDataProvider().getSampleData()


        Column(modifier = Modifier.padding(10.dp)) {
            Text(
                text = "Upcoming Date:",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                color = black,
            )

            Spacer(modifier = Modifier.height(16.dp))

            CardView(dateList.get(0))

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Next Dates:",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                color = black,
            )

            LazyColumn {
                items(dateList) { dates ->
                    CardView(dates)
                    Spacer(modifier = Modifier.height(16.dp))
                }
//                item {
//                    Box(
//                        modifier = Modifier.height(80.dp)
//                    )
//                }
            }
        }
    }

}