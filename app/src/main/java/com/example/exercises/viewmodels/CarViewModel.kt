package com.example.exercises.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exercises.RestAPI.CarService.Car
import com.example.exercises.RestAPI.RetrofitClient
import kotlinx.coroutines.launch

class CarViewModel: ViewModel() {

    private val retrofitClient = RetrofitClient()
    val cars = mutableStateListOf<Car>()

    init {
        fetchCars()
    }

    fun fetchCars() {
        cars.clear()
        viewModelScope.launch {
            val response = retrofitClient.api.getCars()
            cars.addAll(response)
        }
    }
}