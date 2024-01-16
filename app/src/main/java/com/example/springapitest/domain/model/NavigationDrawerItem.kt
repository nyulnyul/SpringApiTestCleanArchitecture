package com.example.springapitest.domain.model

import androidx.compose.ui.graphics.painter.Painter

data class NavigationDrawerItem(
    val image: Painter,
    val route : String,
    val title: String
)
