package com.example.exercises.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.exercises.ui.theme.ExercisesTheme

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
        Column(modifier =
            modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(12.dp)
        ) {
            Button(onClick = onSoMePress, colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)) {
                Text(text = "Lec 1: Social Media Profile", style = MaterialTheme.typography.bodyLarge)
            }
            Button(onClick = onGroupPress) {
                Text("Lec 2: Group Members Page", style = MaterialTheme.typography.bodyLarge)
            }
            Button(onClick = onCarsPress) {
                Text("Lec 3: REST API", style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}

@Preview
@Composable
fun HomePreview(){
    ExercisesTheme{
        HomePage(onGroupPress = {}, onSoMePress = {}, onCarsPress = {})
    }
}