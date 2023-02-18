package com.istudio.diary.navigation

import com.istudio.diary.util.Constants.WRITE_SCREEN_ARGUMENT_KEY

/**
 * This Class represents all the screen navigation that happens in the project
 * ***
 * Notes:
 * Here mentioning "?" means optional parameters and we add key and value pairs
 */
sealed class Screen(val route : String) {
    object Authentication : Screen(route = "authentication_screen")
    object Home : Screen(route = "home_screen")
    object Write : Screen(route = "write_screen?$WRITE_SCREEN_ARGUMENT_KEY={$WRITE_SCREEN_ARGUMENT_KEY}"){
        // Using the below function, we are just constructing the route that is passed to write screen
        fun passDiaryId(diaryId:String) : String{
            return "write_screen?$WRITE_SCREEN_ARGUMENT_KEY=$diaryId"
        }
    }
}