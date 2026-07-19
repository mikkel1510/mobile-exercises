package com.example.exercises.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    color: Color? = null,
){
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = color ?: MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        ),
        shape = RoundedCornerShape(16.dp),
        modifier = modifier,
        enabled = enabled,
    ){
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium
        )
    }
}

@Composable
fun MyTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String?,
    modifier: Modifier = Modifier
){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        textStyle = MaterialTheme.typography.bodyMedium,
        shape = RoundedCornerShape(16.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.onPrimary,
            unfocusedContainerColor = MaterialTheme.colorScheme.background,
            focusedLabelColor = MaterialTheme.colorScheme.primary,
            unfocusedLabelColor = Color.Gray,
        ),
        label = label?.let {
            {
                Text(
                    text = it,
                )
            }
        }
    )
}

@Preview
@Composable
fun FullPreview(){
    ExercisesTheme {
        Column(
            Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(12.dp)
        ) {
            MyButton(
                text = "Hello",
                onClick = {  }
            )
            var query = ""
            MyTextField(
                value = query,
                onValueChange = { query = it },
                label = "Helloo",
            )
        }
    }
}

@Preview
@Composable
fun MyButtonPreview(){
    ExercisesTheme{
        MyButton(
            text = "Hello",
            onClick = {},
        )
    }
}

@Preview
@Composable
fun MyTextFieldPreview(){
    ExercisesTheme {
        var query = ""
        MyTextField(
            value = query,
            onValueChange = { query = it },
            label = "Howdy"
        )
    }
}