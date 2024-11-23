package com.example.temp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.temp.ui.route.Route

@Preview
@Composable
private fun RegisterScreenPreview() {
    RegisterScreen(rememberNavController())
}

@Composable
fun RegisterScreen(navController: NavHostController) {

    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var repeatPassword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically)
    ) {
        Text(
            text = "App quản lý\nthiết bị điện",
            style = MaterialTheme.typography.titleLarge.copy(fontSize = 45.sp),
            color = Color.Black
        )

        MyTextField(
            value = username,
            placeholder = {
                Text(
                    "Nhập tên người dùng", style = MaterialTheme.typography.titleSmall
                )
            },
            onValueChange = { username = it },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        )

        MyTextField(
            value = email,
            placeholder = {
                Text(
                    "Nhập email", style = MaterialTheme.typography.titleSmall
                )
            },
            onValueChange = { email = it },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        )

        MyTextField(
            value = password,
            placeholder = {
                Text(
                    "Nhập mật khẩu", style = MaterialTheme.typography.titleSmall
                )
            },
            onValueChange = { password = it },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        )

        MyTextField(
            value = repeatPassword,
            placeholder = {
                Text(
                    "Nhập lại mật khẩu", style = MaterialTheme.typography.titleSmall
                )
            },
            onValueChange = { repeatPassword = it },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        )

        Button(
            onClick = { navController.navigate(Route.MAIN.name) },
            modifier = Modifier
                .padding(horizontal = 40.dp)
                .fillMaxWidth()
        ) {
            Text("Đăng ký", style = MaterialTheme.typography.titleSmall)
        }
        Text(
            text = "Đã có tài khoản? Đăng nhập",
            style = MaterialTheme.typography.titleSmall.copy(fontSize = 16.sp),
            modifier = Modifier
                .clickable {
                    navController.navigate(Route.LOGIN.name) {
                        popUpTo(Route.LOGIN.name) {
                            inclusive = true
                        }
                    }
                }
        )
    }
}