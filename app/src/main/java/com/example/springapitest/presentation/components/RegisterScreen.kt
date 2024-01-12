package com.example.springapitest.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.springapitest.presentation.viewmodel.RegisterViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserScreen(viewModel: RegisterViewModel, navController: NavController) {
    val userData = viewModel.userData.value

    val isRegisterSuccess by viewModel.isRegisterSuccess.observeAsState(false)
    val registerErrorMessage by viewModel.registerErrorMessage.observeAsState("")



    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column {

        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") }
        )
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") }
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") }
        )
        Button(onClick = {
            viewModel.registerUser( password = password, name = name, email = email)
            if (isRegisterSuccess) {
                navController.navigate("login")
            }

        }) {
            Text("가입")
        }
        if (!isRegisterSuccess && registerErrorMessage.isNotEmpty()) {
            Text(registerErrorMessage, modifier = Modifier.padding(16.dp), Color.Red)
        }
    }
}