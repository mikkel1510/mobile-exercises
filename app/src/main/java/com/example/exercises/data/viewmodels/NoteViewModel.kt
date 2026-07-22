package com.example.exercises.data.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.exercises.data.model.Note
import com.example.exercises.data.repositories.NoteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class NoteViewModel : ViewModel() {
    private val noteRepo: NoteRepository = NoteRepository()

    private val _notesList = MutableStateFlow<List<Note>>(emptyList())
    val notesList = _notesList.asStateFlow()

    init {
        noteRepo.listenToNotes(
            onNotesUpdated = { fetchedNotes ->
                _notesList.value = fetchedNotes
            }
        )
    }

    fun createNote(author: String, note: String){
        val note = Note(author = author, content = note)
        noteRepo.createNote(note)
    }


}