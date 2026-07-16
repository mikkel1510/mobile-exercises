package com.example.exercises.pages

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exercises.R
import com.example.exercises.ui.theme.ExercisesTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profile(name: String, modifier: Modifier = Modifier, onBackPress: () -> Unit) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text("$name's Profile")
                },
                navigationIcon = {
                    IconButton(onClick = { onBackPress() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(5.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = name,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
                Image(
                    painter = painterResource(id = R.drawable.fella),
                    contentDescription = "Feller",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(200.dp)
                        .border(2.dp, Color.Blue, CircleShape)
                )
                var addFriend by remember { mutableStateOf(true) }
                var addToGroup by remember { mutableStateOf(true) }
                Row(
                    Modifier.height(65.dp),
                ) {
                    Button(
                        onClick = { addFriend = !addFriend; },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (addFriend) Color.Blue else Color.Red,
                            contentColor = Color.White
                        ),
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f)
                    ) {
                        Text(
                            text = if (addFriend) "Add Friend" else "Remove Friend",
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                    Button(
                        onClick = { addToGroup = !addToGroup },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (addToGroup) Color.Blue else Color.Red,
                            contentColor = Color.White
                        ),
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f)
                    ) {
                        Text(
                            text = if (addToGroup) "Add to WeShare group" else "Remove from WeShare group",
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
            InfoBox("Odense", "Single", "01-01-1952", "Netto")
        }
    }
}

@Composable
fun InfoBox(city: String, relationStatus: String, birthday: String, job: String) {
    Column(
        Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(15.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)){
            Text("Personal Information", fontSize = 30.sp, fontWeight = FontWeight.Bold)
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                Text("City: ", fontWeight = FontWeight.Bold, fontSize = 25.sp)
                Text(city, fontSize = 25.sp)
            }
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                Text("Birthday: ", fontWeight = FontWeight.Bold, fontSize = 25.sp)
                Text(birthday, fontSize = 25.sp)
            }
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                Text("Relationship Status: ", fontWeight = FontWeight.Bold, fontSize = 25.sp)
                Text(relationStatus, fontSize = 25.sp)
            }
        }
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)){
            Text("Work", fontSize = 30.sp, fontWeight = FontWeight.Bold)
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                Text("Workplace: ", fontWeight = FontWeight.Bold, fontSize = 25.sp)
                Text(job, fontSize = 25.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    ExercisesTheme {
        Profile(name = "Steve Bobby", onBackPress = {})
    }
}