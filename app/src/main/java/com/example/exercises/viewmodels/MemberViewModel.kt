package com.example.exercises.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

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