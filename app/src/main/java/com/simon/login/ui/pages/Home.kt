package com.simon.login.ui.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.simon.login.viewModel.AuthViewModel
import kotlin.simon.login.R

@Composable
fun Homepage(modifier: Modifier=Modifier,navController: NavController,authViewModel: AuthViewModel) {
    
    Column(modifier=Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = R.drawable.shopify), contentDescription ="Login image",modifier=Modifier.size(100.dp) )
        Text(text = "Welcome to Shopify")
    }
}