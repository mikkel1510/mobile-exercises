package com.example.exercises

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exercises.ui.theme.ExercisesTheme
import androidx.lifecycle.viewmodel.compose.viewModel
@Composable
fun Group(modifier: Modifier = Modifier, vm: MemberViewModel = viewModel()) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        //val members = rememberSaveable { mutableStateListOf<String>() }
        var query by rememberSaveable { mutableStateOf("") }
        Row(
            Modifier
                .height(50.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            TextField(
                value = query,
                onValueChange = {query = it},
                label = { Text("Name") },
                modifier = Modifier.fillMaxHeight()
            )
            Button(
                //onClick = { members.add(query); query = "" },
                onClick = { vm.addMember(query) },
                modifier = Modifier.fillMaxHeight()
            ) {
                Text("Add")
            }
        }
        //Members(members = members, onRemove = { member -> members.removeAt(member) })
        Members(members = vm.members, onRemove = { member -> vm.removeMember(member) })
    }
}

@Composable
fun Members(members: List<String>, onRemove: (Int) -> Unit){
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        members.forEach { member ->
            Row(
                Modifier
                    .height(60.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.LightGray)
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(member, fontSize = 20.sp)
                Button(onClick = { onRemove(members.indexOf(member)) }, colors = ButtonDefaults.buttonColors(containerColor = Color.Red)) {
                    Text(text = "Remove", fontSize = 20.sp)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GroupPreview() {
    ExercisesTheme {
        Group()
    }
}

@Preview(showBackground = true)
@Composable
fun MembersPreview(){
    val members = rememberSaveable { mutableStateListOf<String>() }
    members.add("Pop")
    members.add("Pete")
    Members(members = members, onRemove = {})
}