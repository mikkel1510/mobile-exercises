package com.example.exercises

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MemberViewModel() : ViewModel(){
    private val _members = mutableStateListOf<String>()
    val members: List<String> = _members

    fun addMember(name: String){
        _members.add(name)
    }

    fun removeMember(index: Int){
        _members.removeAt(index)
    }
}