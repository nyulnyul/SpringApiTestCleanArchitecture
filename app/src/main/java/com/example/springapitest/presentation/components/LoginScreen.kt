package com.example.springapitest.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Snackbar
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
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.springapitest.R
import com.example.springapitest.presentation.viewmodel.LoginViewModel
import kotlinx.coroutines.NonDisposableHandle.parent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen( navController: NavController, viewModel: LoginViewModel) {
    val isLoginSuccess by viewModel.isLoginSuccess.observeAsState(false)
    val loginErrorMessage by viewModel.loginErrorMessage.observeAsState("")



    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .align(alignment = androidx.compose.ui.Alignment.CenterHorizontally)
        ) {

            Image(
                painterResource(id = R.drawable.world),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                   )


        }
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("이메일") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        TextField(
            value = password,
            onValueChange = { password = it},
            label = { Text("비밀번호") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        Button(onClick = {
            viewModel.login(email, password)

            if (isLoginSuccess) {
                navController.navigate("postList")
            }
        }) {
            Text("로그인")
        }

        Button(onClick = { navController.navigate("register")}) {
            Text("회원가입")

        }
        if (!isLoginSuccess && loginErrorMessage.isNotEmpty()) {
            Text(loginErrorMessage, modifier = Modifier.padding(16.dp), Color.Red)
        }
    }
}