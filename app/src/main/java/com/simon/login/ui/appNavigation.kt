package com.simon.login.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.simon.login.ui.pages.Homepage
import com.simon.login.ui.pages.LoginPage
import com.simon.login.ui.pages.SignUpPage
import com.simon.login.viewModel.AuthViewModel

@Composable
fun AppNavigation(modifier: Modifier=Modifier,authViewModel: AuthViewModel){
    val navController=rememberNavController()

    NavHost(navController = navController, startDestination ="login",builder={
        composable("login"){
            LoginPage(modifier,navController,authViewModel)
        }
        composable("signup"){
            SignUpPage(modifier,navController,authViewModel )
        }
        composable("homepage"){
            Homepage(modifier,navController,authViewModel )
        }
    } )
}