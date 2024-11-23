@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.temp.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.temp.R
import com.example.temp.ui.route.Route
import com.example.temp.ui.screen.BoltScreen
import com.example.temp.ui.screen.ItemScreen
import com.example.temp.ui.screen.LoginScreen
import com.example.temp.ui.screen.MyTextField
import com.example.temp.ui.screen.NotificationScreen
import com.example.temp.ui.screen.RegisterScreen
import com.example.temp.ui.screen.SwitchScreen

data class Item(val name: String, @DrawableRes val icon: Int, val route: Route)

@Preview
@Composable
fun App() {

    val navController = rememberNavController()
    val items = listOf(
        Item("Quản lý bật tắt", R.drawable.ic_switch, Route.SWITCH),
        Item("Trang chủ", R.drawable.ic_home, Route.ITEM),
        Item("Thống kê công suất", R.drawable.ic_bolt, Route.BOLT),
    )

    var currentRoute by remember { mutableStateOf(Route.LOGIN.name) }

    LaunchedEffect(navController) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            currentRoute = destination.route.toString()
        }
    }

    Scaffold(
        bottomBar = {
            if (currentRoute != Route.LOGIN.name && currentRoute != Route.REGISTER.name) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                        .background(Color(0xFFeef3dd))
                ) {
                    items.forEach { item ->
                        Column(
                            modifier = Modifier
                                .fillMaxHeight()
                                .weight(1f)
                                .clickable {
                                    navController.navigate(item.route.name) {
                                        launchSingleTop = true
                                    }
                                },
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                painter = painterResource(item.icon),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(40.dp)
                                    .padding(4.dp)
                            )

                            Text(
                                item.name,
                                style = MaterialTheme.typography.labelSmall.copy(fontSize = 12.sp),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        },
        topBar = {
            if (currentRoute != Route.LOGIN.name && currentRoute != Route.REGISTER.name) {

                var searchBarText by remember { mutableStateOf("") }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    DockedSearchBar(inputField = {
                        MyTextField(value = searchBarText,
                            onValueChange = { searchBarText = it },
                            modifier = Modifier.fillMaxWidth(),
                            placeholder = {
                                Text(
                                    "Tìm kiếm", style = MaterialTheme.typography.titleMedium
                                )
                            })
                    }, expanded = false, onExpandedChange = {}, modifier = Modifier.weight(1f)
                    ) {}

                    Icon(painter = painterResource(R.drawable.ic_bell),
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)
                            .padding(horizontal = 4.dp)
                            .clickable {
                                navController.navigate(Route.NOTIFICATION.name) {
                                    launchSingleTop = true
                                }
                            })

                    Icon(painter = painterResource(R.drawable.ic_off),
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)
                            .padding(horizontal = 4.dp)
                            .clickable {
                                navController.navigate(Route.LOGIN.name) {
                                    popUpTo(Route.LOGIN.name) { inclusive = true }
                                }
                            })
                }

            }
        },
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(top = 24.dp)
    ) { paddingValues ->
        NavHost(
            navController = navController,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 12.dp)
                .padding(paddingValues),
            startDestination = Route.LOGIN.name
        ) {
            composable(route = Route.LOGIN.name) { LoginScreen(navController) }
            composable(route = Route.REGISTER.name) { RegisterScreen(navController) }
            navigation(startDestination = Route.ITEM.name, route = Route.MAIN.name) {
                composable(route = Route.ITEM.name) { ItemScreen() }
                composable(route = Route.SWITCH.name) { SwitchScreen() }
                composable(route = Route.BOLT.name) { BoltScreen(navController = navController) }
                composable(route = Route.NOTIFICATION.name) { NotificationScreen(navController = navController) }
            }
        }
    }
}