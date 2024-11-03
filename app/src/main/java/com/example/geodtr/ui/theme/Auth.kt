package com.example.geodtr.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.geodtr.R

@Composable
fun AuthenticationScreen(onAuthSuccess: () -> Unit, onSignUpClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Image
            Image(
            painter = painterResource(id = R.drawable.img_5), // Your image resource
            contentDescription = "Authentication Logo",
            modifier = Modifier.size(450.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Text below the image
        Text(text = "Please authenticate to continue", fontSize = 15.sp)

        Spacer(modifier = Modifier.height(16.dp))

        // Authenticate button
        Button(onClick = {
            onAuthSuccess() // Trigger authentication success
        }) {
            Text("Authenticate")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Sign up button
        // Navigate to Sign Up

        }
    }
