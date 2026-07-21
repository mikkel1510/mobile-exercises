package com.example.exercises.data.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.exercises.data.model.User
import com.example.exercises.data.repositories.TestRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AuthViewModel : ViewModel() {
    private val userRepo: TestRepository = TestRepository()
    private val _currentUser = MutableStateFlow("")
    val currentUser = _currentUser.asStateFlow()

    fun setName(name: String){
        _currentUser.value = name
    }

    fun createUser(name: String, email: String, password: String){
        val user = User(name = name, email = email, password = password)
        userRepo.createUser(user)
    }
}