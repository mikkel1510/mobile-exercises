package com.example.exercises.data.viewmodels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exercises.RestAPI.CarService.Car
import com.example.exercises.RestAPI.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CarViewModel: ViewModel() {

    private val retrofitClient = RetrofitClient()
    val cars = mutableStateListOf<Car>()

    val isLoading = MutableStateFlow(false)

    init {
        fetchCars()
    }

    fun fetchCars() {
        cars.clear()
        viewModelScope.launch {
            isLoading.value = true
            try {
                val response = retrofitClient.api.getCars()
                cars.addAll(response)
                isLoading.value = false
            } catch (e: Exception){
                Log.e("CarViewModel", "Could not fetch cars", e)
            }
        }
    }
}