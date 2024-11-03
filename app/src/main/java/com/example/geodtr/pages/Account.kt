package com.example.geodtr.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.geodtr.R

@Composable
fun Account(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF5F8C60))
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Top row with account icon, title, and edit icon
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Account icon
            IconButton(onClick = { /* Handle account action */ }) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Account Icon",
                    tint = Color.White
                )
            }

            // Title
            Text(
                text = "Profile Details",
                fontSize = 40.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )

            // Edit icon
            IconButton(onClick = { /* Handle edit action */ }) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit Icon",
                    tint = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Profile Picture
        Image(
            painter = painterResource(id = R.drawable.img_1), // Replace with your profile picture resource
            contentDescription = "Profile Picture",
            modifier = Modifier.size(100.dp) // Adjust size as needed
        )

        Spacer(modifier = Modifier.height(16.dp))

        // ID Number
        UserProfileInfo(label = "ID Number:", value = "764539")

        // User profile information
        UserProfileInfo(label = "Name:", value = "John Doe")
        UserProfileInfo(label = "Address:", value = "456 Elm St, Cityville")
        UserProfileInfo(label = "Contact No:", value = "+9876543210")
        UserProfileInfo(label = "Age:", value = "32")
        UserProfileInfo(label = "Date of Birth:", value = "February 2, 1992")
        UserProfileInfo(label = "Company Name:", value = "Example Corp")
        UserProfileInfo(label = "Position:", value = "Developer")
        UserProfileInfo(label = "Department:", value = "Development")
        UserProfileInfo(label = "Emergency Contact:", value = "+01234")

        Spacer(modifier = Modifier.height(32.dp))

        // Log out button
        Button(
            onClick = { /* Handle log out action */ },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Log Out")
        }
    }
}

@Composable
fun UserProfileInfo(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Text(
            text = value,
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            color = Color.White
        )
    }
}
