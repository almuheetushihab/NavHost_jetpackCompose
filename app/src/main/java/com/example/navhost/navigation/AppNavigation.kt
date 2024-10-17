package com.example.navhost.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navhost.screena.ScreenA
import com.example.navhost.screenb.ScreenB

@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "screen_a") {

        composable("screen_a") {
            ScreenA(navController)
        }


        composable(
            "screen_b/{name}",
            arguments = listOf(navArgument("name") { type = NavType.StringType })
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name")
            ScreenB(name = name ?: "No Name")
        }
    }
}