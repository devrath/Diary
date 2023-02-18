package com.istudio.diary.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.ActivityNavigator
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.istudio.diary.util.Constants.WRITE_SCREEN_ARGUMENT_KEY

/**
 *
 * Arguments:
 * startDestination -> This will point to the start destination of the nav-graph
 * navController -> navigation Controller
 */
@Composable
fun SetupNavGraph(
    startDestination: String, navController:NavHostController
){
    NavHost(
        navController = navController,
        startDestination = startDestination
    ){
        authenticationRoute()
        homeRoute()
        writeRoute()
    }
}

fun NavGraphBuilder.authenticationRoute(){
    composable(route = Screen.Authentication.route){
        // Here there will be the contents of the screen

    }
}

fun NavGraphBuilder.homeRoute(){
    composable(route = Screen.Home.route){
        // Here there will be the contents of the screen

    }
}

fun NavGraphBuilder.writeRoute(){
    composable(
        route = Screen.Write.route,
        arguments = listOf(navArgument(name = WRITE_SCREEN_ARGUMENT_KEY){
            type = NavType.StringType
            // Setting nullable true indicates, if no values are passed to arguments, a default null value will be taken
            nullable = true
            defaultValue = null
        })
    ){
        // Here there will be the contents of the screen

    }
}