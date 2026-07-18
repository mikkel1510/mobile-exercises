package com.example.exercises.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
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
import com.example.exercises.ui.theme.MyButton
import com.example.exercises.ui.theme.MyTextField
import com.example.exercises.viewmodels.MemberViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Group(modifier: Modifier = Modifier, vm: MemberViewModel = viewModel(), onBackPress: () -> Unit) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text("Group Members")
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
                .fillMaxSize()
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp),
        ) {
            //val members = rememberSaveable { mutableStateListOf<String>() }
            var query by rememberSaveable { mutableStateOf("") }
            Row(
                Modifier
                    .height(IntrinsicSize.Min)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                MyTextField(
                    value = query,
                    onValueChange = { query = it },
                    label = "Name",
                )
                MyButton(
                    text = "Add",
                    onClick = { vm.addMember(query) },
                    modifier = Modifier.fillMaxHeight().padding(top = 8.dp)
                )
                /*Button(
                    //onClick = { members.add(query); query = "" },
                    onClick = { vm.addMember(query) },
                    modifier = Modifier.fillMaxHeight()
                ) {
                    Text("Add")
                }*/
            }

            //Members(members = members, onRemove = { member -> members.removeAt(member) })
            Members(members = vm.members, onRemove = { member -> vm.removeMember(member) })
        }
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
        Group(onBackPress = {})
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