package com.example.exercises.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.exercises.ui.theme.ExercisesTheme
import com.example.exercises.ui.theme.MyButton
import com.example.exercises.data.viewmodels.AuthViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(
    modifier: Modifier = Modifier,
    onGroupPress: () -> Unit,
    onSoMePress: () -> Unit,
    onCarsPress: () -> Unit,
    onLoginPress: () -> Unit,
    onNotesPress: () -> Unit,
    authVM: AuthViewModel
){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Exercises") },
            )
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Row(
                Modifier
                    .clip(MaterialTheme.shapes.medium)
                    .background(MaterialTheme.colorScheme.surface)
                    .fillMaxWidth()
                    .padding(12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row{
                    val currentUser by authVM.currentUser.collectAsState()
                    Text("Hello ")
                    Text(currentUser.ifEmpty { "stranger" }, fontWeight = FontWeight.Bold)
                }
                MyButton("Edit Name", { onLoginPress() })
            }
            Column(
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
                Button(onClick = onNotesPress) {
                    Text("Lec 4: Firestore", style = MaterialTheme.typography.bodyLarge)
                }
            }

        }
    }
}

@Preview
@Composable
fun HomePreview(){
    ExercisesTheme{
        HomePage(onGroupPress = {}, onSoMePress = {}, onCarsPress = {}, onLoginPress = {}, onNotesPress = {}, authVM = viewModel())
    }
}