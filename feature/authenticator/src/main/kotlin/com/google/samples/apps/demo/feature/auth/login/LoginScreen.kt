package com.google.samples.apps.demo.feature.auth.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.samples.apps.demo.feature.auth.AuthNavigationEvent

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    onNavigation: (AuthNavigationEvent) -> Unit
) {
    LoginContent(onNavigation = onNavigation) { email, password ->
        viewModel.loginUser(email, password){
            onNavigation(AuthNavigationEvent.OnLoginCompleted)
        }
    }
}

@Composable
private fun LoginContent(
    onNavigation: (AuthNavigationEvent) -> Unit,
    onLoginClick: (String, String) -> Unit,
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val isLoginEnabled by remember {
        derivedStateOf { email.isNotEmpty() && password.isNotEmpty() }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Login", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { onLoginClick(email, password) },
            enabled = isLoginEnabled,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(text = "Login")
        }
        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { onNavigation(AuthNavigationEvent.OnRegisterClick) },
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(text = "Register")
        }
        Button(
            onClick = { onNavigation(AuthNavigationEvent.OnForgetPasswordClick) },
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(text = "Forget Password")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen {}
}
