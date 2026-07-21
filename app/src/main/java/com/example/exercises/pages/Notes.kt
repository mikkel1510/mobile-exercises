package com.example.exercises.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.exercises.data.viewmodels.AuthViewModel
import com.example.exercises.ui.theme.ExercisesTheme
import com.example.exercises.ui.theme.MyButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesPage(
    onBackPress: () -> Unit,
    authVM: AuthViewModel
){
    Scaffold(
        topBar = { TopAppBar(
            title = {
                Text("Notes"
                ) },
            navigationIcon = {
                IconButton(onClick = { onBackPress() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        ) }
    ) { innerPadding ->
        Column(
            Modifier
                .padding(innerPadding)
                .padding(12.dp)
        ) {
            Text("Howdy")
            MyButton(
                text = "Test",
                onClick = { authVM.createUser("testuser", "testemail", "1234") }
            )
        }
    }
}

@Preview
@Composable
fun NotesPreview(){
    ExercisesTheme {
        NotesPage(
            onBackPress = {},
            authVM = viewModel()
        )
    }
}