package com.example.exercises

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import com.example.exercises.ui.theme.ExercisesTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExercisesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Profile(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Profile(name: String, modifier: Modifier = Modifier) {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){
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
                    .border(1.dp, Color.Blue, CircleShape)
            )
            var addFriend by remember { mutableStateOf(true) }
            var addToGroup by remember { mutableStateOf(true) }
            Row(
                Modifier.height(75.dp),
            ) {
                Button(
                    onClick = { addFriend = !addFriend; },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (addFriend) Color.Blue else Color.Red,
                        contentColor = Color.White
                    ),
                    modifier = Modifier.fillMaxHeight().weight(1f)
                ) {
                    Text(
                        text = if (addFriend) "Add Friend" else "Remove Friend",
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center
                    )
                }
                Button(
                    onClick = { addToGroup = !addToGroup},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (addToGroup) Color.Blue else Color.Red,
                        contentColor = Color.White
                    ),
                    modifier = Modifier.fillMaxHeight().weight(1f)
                ) {
                    Text(
                        text = if (addToGroup) "Add to WeShare group" else "Remove from WeShare group",
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
        InfoBox("Odense", "Single")
    }


}

@Composable
fun InfoBox(city: String, relationStatus: String) {
    Column(
        Modifier
            .padding(10.dp)
            .background(Color.Gray)
            .fillMaxWidth()
            .padding(10.dp),
    ) {
        Text("City: $city")
        Text("Relationship Status: $relationStatus")
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    ExercisesTheme {
        Profile("Steve Bobby")
    }
}