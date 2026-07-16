package com.example.exercises.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.exercises.R
import com.example.exercises.RestAPI.CarService.Car
import com.example.exercises.viewmodels.CarViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Cars(onBackPress: () -> Unit, carVM: CarViewModel = viewModel()){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Cars")
                },
                navigationIcon = {
                    IconButton(onClick = { onBackPress() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            Modifier.padding(innerPadding),
        ) {
            Column(
                Modifier.padding(10.dp),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                carVM.cars.forEach { car ->
                    Car(car)
                }
            }
        }

    }
}

@Composable
fun Car(car: Car){
    Row(Modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(12.dp))
        .background(Color.LightGray)
        .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.car),
            contentDescription = "Car",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
        )
        Column(horizontalAlignment = Alignment.End, verticalArrangement = Arrangement.spacedBy(5.dp)) {
            Text(car.brand, fontSize = 24.sp)
            Text(car.model, fontSize = 20.sp)
            Text(car.price.toString()+ "$", fontSize = 20.sp)
        }
    }
}

@Preview
@Composable
fun CarsPreview() {
    val previewCars = listOf(
        Car(id = 1, brand = "Mercedes-Benz", model = "Citan", bodyType = "Van", color = "Red", price = 10000, year = 2010),
        Car(id = 2, brand = "Lexus", model = "GX", bodyType = "4WD", color = "Black", price = 50000, year = 2020),
        Car(id = 3, brand = "Toyota", model = "RAV4", bodyType = "Crossover", color = "Gray", price = 15000, year = 2015),
        Car(id = 4, brand = "Hyundai", model = "Grand i10 Nios", bodyType = "Hatchback", color = "Yellow", price = 30000, year = 2018),
        Car(id = 5, brand = "Honda", model = "Civic", bodyType = "Sedan", color = "Blue", price = 25000, year = 2010)
    )
    val carVM = CarViewModel()
    carVM.cars.addAll(previewCars)

    Cars({}, carVM)
}