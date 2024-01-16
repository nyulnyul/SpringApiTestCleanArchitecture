package com.example.springapitest.presentation.components.Home

import android.content.res.Resources.Theme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.springapitest.R
import com.example.springapitest.presentation.components.IronBirdSurface
import com.example.springapitest.ui.theme.SpringApiTestTheme

fun NavGraphBuilder.addHomeGraph(
    onSnackSelected: (Long, NavBackStackEntry) -> Unit,
    onNavigateToRoute: (String) -> Unit,
    modifier : Modifier = Modifier
){
    composable(HomeSections.FEED.route){

    }
    composable(HomeSections.SEARCH.route){

    }
    composable(HomeSections.SHARE.route){

    }
    composable(HomeSections.CREATE.route){

    }
    composable(HomeSections.MYPAGE.route){

    }
}
enum class HomeSections(val title: String, val icon: ImageVector, val route: String) {
    FEED("홈", Icons.Outlined.Home, "home/feed"),
    SEARCH("검색", Icons.Outlined.Search, "home/search"),
    SHARE("공유", Icons.Outlined.Share, "home/share"),
    CREATE("만들기", Icons.Outlined.Add, "home/create"),
    MYPAGE("마이페이지", Icons.Outlined.AccountCircle, "home/mypage")
}

@Composable
fun NavBottomBar(
    tabs: Array<HomeSections>,
    currentRoute : String,
    navigateToRoute: (String) -> Unit,
    color: androidx.compose.ui.graphics.Color = Color(R.color.purple_500),
    contentColor: androidx.compose.ui.graphics.Color = Color(R.color.white)
){

}
