package com.google.samples.apps.demo.feature.auth.forgetPassword

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.samples.apps.demo.feature.auth.AuthNavigationEvent

@Composable
fun ForgetPasswordScreen(
    viewModel: ForgetPasswordViewModel = hiltViewModel(),
    onNavigation: (AuthNavigationEvent) -> Unit,
) {
    ForgetPasswordContent { email ->
        viewModel.forgetPassword(email) {
            onNavigation(AuthNavigationEvent.OnForgetPasswordCompleted)
        }
    }
}

@Composable
private fun ForgetPasswordContent(onForgetPasswordClick: (String) -> Unit) {
    var email by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 56.dp)
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Forget Password", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(16.dp))

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { onForgetPasswordClick(email) },
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(text = "Forget Password")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ForgetPasswordScreenPreview() {
    ForgetPasswordScreen {}
}