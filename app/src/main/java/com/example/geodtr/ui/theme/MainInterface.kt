package com.examination.mylogin

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.geodtr.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(onLoginSuccess: () -> Unit, onSignUpClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Login Image",
            modifier = Modifier.size(200.dp)
        )


        OutlinedTextField(value = "", onValueChange = {}, label = {
            Text(text = "Username")
        })

        Spacer(modifier = Modifier.height(13.dp))

        OutlinedTextField(value = "", onValueChange = {}, label = {
            Text(text = "Password")
        })

        Spacer(modifier = Modifier.height(13.dp))

        Button(onClick = {
            onLoginSuccess() // Trigger login success
        }) {
            Text("Log In")
        }

        Spacer(modifier = Modifier.height(4.dp))

        Text(text = "or")

        Spacer(modifier = Modifier.height(4.dp))

        Button(onClick = { /* Handle Google Sign-In */ }) {
            Text(text = "Sign in with Google")
        }

        Spacer(modifier = Modifier.height(8.dp))

        TextButton(onClick = onSignUpClick) { // Handle Sign Up
            Text(text = "Don't have an account? Sign up")
        }
    }
}