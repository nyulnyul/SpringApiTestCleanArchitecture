package com.example.springapitest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.springapitest.presentation.components.RegisterApp
import com.example.springapitest.presentation.viewmodel.RegisterViewModel
import com.example.springapitest.ui.theme.SpringApiTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = RegisterViewModel()

        setContent {
            SpringApiTestTheme {
                // A surface container using the 'background' color from the theme
                RegisterApp()
            }

        }
    }
}

