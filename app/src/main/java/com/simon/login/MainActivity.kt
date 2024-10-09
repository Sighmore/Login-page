package com.simon.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.simon.login.ui.AppNavigation
import com.simon.login.ui.theme.LoginTheme
import com.simon.login.viewModel.AuthViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //created the viewModel from here and passed it
        val authViewModel: AuthViewModel by viewModels()
        setContent {
            LoginTheme {

                AppNavigation(modifier = Modifier.padding(10.dp), authViewModel = authViewModel)

            }
        }
    }
}
