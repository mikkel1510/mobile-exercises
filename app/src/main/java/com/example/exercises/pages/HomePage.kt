package com.example.exercises.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(
    modifier: Modifier = Modifier,
    onGroupPress: () -> Unit,
    onSoMePress: () -> Unit,
    onCarsPress: () -> Unit
){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Exercises") },
            )
        }
    ) { innerPadding ->
        Column(modifier = modifier.padding(innerPadding)) {
            Button(onClick = onSoMePress) {
                Text("Lec 1: Social Media Profile")
            }
            Button(onClick = onGroupPress) {
                Text("Lec 2: Group Members Page")
            }
            Button(onClick = onCarsPress) {
                Text("Lec 3: REST API")
            }
        }
    }
}

@Preview
@Composable
fun HomePreview(){
    HomePage(onGroupPress = {}, onSoMePress = {}, onCarsPress = {})
}