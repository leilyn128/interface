package com.example.geodtr

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier

@Composable
fun SignUpScreen(onSignUpSuccess: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp), // Removed background color
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo), // Your logo resource
            contentDescription = "Logo",
            modifier = Modifier.size(200.dp)
        )

        // Input fields for sign up
        TextField(value = "", onValueChange = {}, label = { Text("Full Name") })
        TextField(value = "", onValueChange = {}, label = { Text("Email Address") })
        TextField(value = "", onValueChange = {}, label = { Text("Username") })
        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation()
        )
        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Confirm Password") },
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            onSignUpSuccess() // Call this when sign-up is successful
        }) {
            Text("Sign up")
        }
    }
}
//another comment