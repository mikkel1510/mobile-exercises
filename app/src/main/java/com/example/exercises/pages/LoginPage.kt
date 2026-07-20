package com.example.exercises.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.exercises.ui.theme.ExercisesTheme
import com.example.exercises.ui.theme.MyButton
import com.example.exercises.ui.theme.MyTextField
import com.example.exercises.viewmodels.AuthViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(
    onBackPress: () -> Unit,
    authVM: AuthViewModel = viewModel()
){
    Scaffold(
        topBar = { TopAppBar(
            title = {
                Text("Login"
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
            var name = rememberSaveable(authVM.currentUser.value){
                mutableStateOf(authVM.currentUser.value)
            }
            Text("Who are you?")
            Row(
                Modifier.height(IntrinsicSize.Min),
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                MyTextField(
                    value = name.value,
                    onValueChange = { name.value = it },
                    label = "Name",
                    Modifier.weight(1f)
                )
                MyButton(
                    text = "Save",
                    onClick = { authVM.setName(name.value); onBackPress() },
                    modifier = Modifier.padding(top = 8.dp).fillMaxHeight()
                )

            }
        }

    }
}

@Preview
@Composable
fun LoginPagePreview(){
    ExercisesTheme {
        LoginPage({})
    }
}