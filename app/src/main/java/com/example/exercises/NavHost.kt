package com.example.exercises

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.exercises.pages.Cars
import com.example.exercises.pages.Group
import com.example.exercises.pages.HomePage
import com.example.exercises.pages.LoginPage
import com.example.exercises.pages.Profile
import com.example.exercises.data.viewmodels.AuthViewModel
import com.example.exercises.pages.NoteScreen

@Composable
fun AppNavigation(modifier: Modifier = Modifier, navController: NavHostController){

    val authVM: AuthViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Routes.START,
        modifier = modifier
    ){

        composable(Routes.START) {
            HomePage(
                onGroupPress = { navController.navigate(Routes.GROUP) },
                onSoMePress = { navController.navigate(Routes.SOME) },
                onCarsPress = { navController.navigate(Routes.CARS) },
                onLoginPress = { navController.navigate(Routes.LOGIN) },
                onNotesPress = { navController.navigate(Routes.NOTES) },
                authVM = authVM
            )
        }

        composable(Routes.GROUP) {
            Group(
                onBackPress = { navController.popBackStack() }
            )
        }

        composable(Routes.SOME){
            Profile(
                name = "Steve Bobby",
                onBackPress = { navController.popBackStack() }
            )
        }

        composable(Routes.CARS){
            Cars(
                onBackPress = { navController.popBackStack() }
            )
        }

        composable(Routes.LOGIN) {
            LoginPage(
                onBackPress = { navController.popBackStack() },
                authVM = authVM
            )
        }

        composable(Routes.NOTES){
            NoteScreen(
                onBackPress = { navController.popBackStack() },
            )
        }
    }
}