package com.example.exercises.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.exercises.data.model.Note
import com.example.exercises.data.viewmodels.NoteViewModel
import com.example.exercises.ui.theme.ExercisesTheme
import com.example.exercises.ui.theme.MyButton
import com.example.exercises.ui.theme.MyTextField
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
    onBackPress: () -> Unit,
    noteVM: NoteViewModel = viewModel()
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
        val notes by noteVM.notesList.collectAsStateWithLifecycle()
        NoteContent(
            modifier = Modifier
                .padding(innerPadding)
                .padding(12.dp),
            createNote = noteVM::createNote,
            notes = notes
        )
    }
}

@Composable
fun NoteContent(
    modifier: Modifier = Modifier,
    createNote: (String, String) -> Unit,
    notes: List<Note>
){
    Column(
        modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Text("Enter your name")
        var author by remember { mutableStateOf("") }
        MyTextField(
            value = author,
            onValueChange = { author = it },
            label = "Author"
        )
        Text("Enter your note")
        var note by remember { mutableStateOf("") }
        MyTextField(
            value = note,
            onValueChange = { note = it },
            label = "Note"
        )
        MyButton(onClick = { createNote(author, note); author = ""; note = "" }, text = "Save")
        NotesList(notes)
    }
}

@Composable
fun NotesList(notes: List<Note>){
    LazyColumn{
        items(notes){ note ->
            NoteCard(note)
        }
    }
}

@Composable
fun NoteCard(note: Note){
    Row(
        Modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.medium)
            .background(MaterialTheme.colorScheme.secondary)
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(note.author)
        Text(note.content)
    }
}

@Preview
@Composable
fun NoteContentPreview(){
    ExercisesTheme {
        NoteContent(
            createNote = { _, _ -> {} },
            notes = listOf(
                Note(author = "Test", content = "Testnote")
            )
        )
    }
}