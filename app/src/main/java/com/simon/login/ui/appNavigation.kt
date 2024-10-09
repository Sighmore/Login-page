package com.simon.login.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.simon.login.ui.pages.LoginPage

@Composable
fun AppNavigation(){
    val navController=rememberNavController()

    NavHost(navController = navController, startDestination ="login",builder={
        composable("login"){
            LoginPage(modifier,navController,authViewModel)
        }
    } )
}