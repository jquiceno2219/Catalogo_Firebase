package com.example.login.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.login.HomeScreen
import com.example.login.LoginScreen

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Login) {

        composable<Login> {
            LoginScreen { email ->
                navController.navigate(Home(userEmail = email))
            }
        }

        composable<Home> { backStackEntry ->
            val home = backStackEntry.toRoute<Home>()
            HomeScreen(userEmail = home.userEmail) {
                navController.navigate(Login) {
                    popUpTo(Login) { inclusive = true }
                }
            }
        }
    }
}