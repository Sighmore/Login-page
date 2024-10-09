package com.simon.login.ui.pages

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.simon.login.viewModel.AuthState
import com.simon.login.viewModel.AuthViewModel
import kotlin.simon.login.R


@Composable
fun LoginPage(modifier: Modifier=Modifier,navController: NavController,authViewModel: AuthViewModel){

    val authState = authViewModel.authState.observeAsState()
    LaunchedEffect(authState.value) {
        when(authState.value) {
            is AuthState.Authenticated -> navController.navigate("homepage")

            else -> Unit
        }
    }

    var userName by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        
        Image(
            painter = painterResource(id = R.drawable.shopify),
            contentDescription = "Login Image",
            modifier = Modifier.size(100.dp)
            )
        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Welcome back", fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Text(text = "login to your account")

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = userName,
            onValueChange = {
                userName=it
                            },
            label = { Text(text = "Username")}
        )
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {password=it},
            label = { Text(text = "Password")}, visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { authViewModel.login(userName, password) },
            enabled = authState.value != AuthState.Loading
            ) {
            Text(text = "Login")
        }
        
        Spacer(modifier = Modifier.height(10.dp))

        TextButton(onClick = { navController.navigate("signup") }) {
            Text(text = "Create account")
        }
        
        Text(text = "Login with")

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(modifier = Modifier.clickable { Log.i("Github", "Google login") },
                painter = painterResource(id = R.drawable.google),
                contentDescription = "Login with google"
            )
            Image(modifier = Modifier.clickable { Log.i("Github", "LinkedIn login") },
                painter = painterResource(id = R.drawable.linkedln),
                contentDescription = "Login with linkedIn"
            )
            Image(modifier = Modifier.clickable { Log.i("Github", "Git login") },
                painter = painterResource(id = R.drawable.github),
                contentDescription = "Login with github"
            )
        }


    }
}