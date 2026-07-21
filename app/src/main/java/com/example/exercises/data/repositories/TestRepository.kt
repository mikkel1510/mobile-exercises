package com.example.exercises.data.repositories

import com.example.exercises.data.model.User
import com.google.firebase.firestore.FirebaseFirestore

class TestRepository {
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()

    fun createUser(user: User){
        db.collection("users")
            .add(user)
    }
}