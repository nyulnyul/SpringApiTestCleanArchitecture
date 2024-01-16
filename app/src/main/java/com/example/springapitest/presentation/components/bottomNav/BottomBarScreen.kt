package com.example.springapitest.presentation.components.bottomNav

import com.example.springapitest.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int,
    val icon_focused: Int
) {
    object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        icon = R.drawable.menu,
        icon_focused = 0
    )
    object plan : BottomBarScreen(
        route = "home",
        title = "Home",
        icon = R.drawable.menu,
        icon_focused = 0
    )
    object share : BottomBarScreen(
        route = "home",
        title = "Home",
        icon = R.drawable.menu,
        icon_focused = 0
    )
    object mypage : BottomBarScreen(
        route = "home",
        title = "Home",
        icon = R.drawable.menu,
        icon_focused = 0
    )

}