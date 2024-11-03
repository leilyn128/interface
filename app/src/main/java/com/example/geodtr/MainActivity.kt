package com.example.geodtr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.material3.ExperimentalMaterial3Api
import com.examination.mylogin.LoginScreen
import com.example.geodtr.ui.theme.AuthenticationScreen
import np.com.bimalkafle.geodtr.Dashboard

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val isLoggedIn = remember { mutableStateOf(false) }
            val isSigningUp = remember { mutableStateOf(false) }
            val isAuthenticating = remember { mutableStateOf(false) } // New state for authentication

            when {
                isLoggedIn.value -> {
                    Dashboard() // Show dashboard if logged in
                }
                isAuthenticating.value -> {
                    AuthenticationScreen(
                        onAuthSuccess = { isLoggedIn.value = true }, // Log in on successful authentication
                        onSignUpClick = {
                            isSigningUp.value = true // Go back to sign-up if needed
                            isAuthenticating.value = false
                        }
                    )
                }
                isSigningUp.value -> {
                    SignUpScreen(onSignUpSuccess = {
                        isAuthenticating.value = true // Go to authentication screen after sign-up
                        isSigningUp.value = false
                    })
                }
                else -> {
                    LoginScreen(
                        onLoginSuccess = {
                            isLoggedIn.value = true // Log in on successful login
                        },
                        onSignUpClick = {
                            isSigningUp.value = true // Switch to sign-up screen
                        }
                    )
                }
            }
        }
    }
}
