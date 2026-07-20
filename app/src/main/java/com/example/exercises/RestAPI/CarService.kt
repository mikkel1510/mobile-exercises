package com.example.exercises.RestAPI

import retrofit2.http.GET
import retrofit2.http.Path

interface CarService {

    data class Car(
        val id: Int,
        val brand: String,
        val model: String,
        val bodyType: String,
        val color: String,
        val price: Int,
        val year: Int,
        val imageURL: String
    )

    @GET("cars/{id}")
    suspend fun getCar(@Path("id") carId: Int): Car

    @GET("mikkel1510/mobile-exercises/refs/heads/main/cars.json")
    suspend fun getCars(): List<Car>
}