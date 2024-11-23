package com.example.temp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Preview
@Composable
fun PreviewNotificationScreen() {
    NotificationScreen(navController = rememberNavController())
}

@Composable
fun NotificationScreen(modifier: Modifier = Modifier, navController: NavHostController) {
    val listNotifications = listOf(
        "Thiết bị 1 hỏng lúc 14:00 11/11/2024",
        "Thiết bị 2 hỏng lúc 17:00 10/11/2024"
    )

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ) {
        itemsIndexed(listNotifications) { _, item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .border(1.dp, Color.Black),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = item,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}