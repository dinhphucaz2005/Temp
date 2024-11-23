@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.temp.ui.screen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
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
import com.example.temp.R
import com.example.temp.ui.theme.TempTheme

@Preview
@Composable
private fun ItemScreenPreview() {
    TempTheme { ItemScreen() }
}

@Composable
fun ItemScreen() {

    var searchBarText by remember { mutableStateOf("") }
    val deviceState = remember { mutableStateListOf("bình thường", "tắt", "hỏng") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            DockedSearchBar(
                inputField = {
                    MyTextField(value = searchBarText,
                        onValueChange = { searchBarText = it },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = {
                            Text(
                                "Tìm kiếm", style = MaterialTheme.typography.titleMedium
                            )
                        })
                },
                expanded = false,
                onExpandedChange = {},
                modifier = Modifier.weight(1f)
            ) {}

            Icon(
                painter = painterResource(R.drawable.ic_bell),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .padding(horizontal = 4.dp)
            )

            Icon(
                painter = painterResource(R.drawable.ic_off),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .padding(horizontal = 4.dp)
            )
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(top = 12.dp),
        ) {
            items(10) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .border(width = 1.dp, color = Color.Black)
                        .padding(horizontal = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        "Thiết bị $it",
                        modifier = Modifier.weight(7f),
                        style = MaterialTheme.typography.labelMedium.copy(fontSize = 16.sp)
                    )

                    Text(
                        text = deviceState.random(),
                        modifier = Modifier.weight(3f), textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.labelMedium.copy(fontSize = 16.sp)
                    )
                }
            }
        }
    }

}