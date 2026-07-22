package com.example.exercises.data.model

import com.google.firebase.firestore.DocumentId

data class Note(
    @DocumentId val id: String = "",
    val author: String = "",
    val content: String = "",
)
