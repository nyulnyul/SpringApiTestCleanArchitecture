package com.example.springapitest.presentation.components.bottomNav

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.springapitest.presentation.components.mypage.mypageScreen
import com.example.springapitest.presentation.components.plan.PlanScreen
import com.example.springapitest.presentation.components.share.ShareScreen

@Composable
fun BottomNavGraph(navController: NavController) {
    NavHost(navController = navController, startDestination =BottomBarScreen.Home.route ){
        composable(BottomBarScreen.Home.route){

        }
        composable(BottomBarScreen.plan.route){
            PlanScreen()
        }
        composable(BottomBarScreen.share.route){
            ShareScreen()
        }
        composable(BottomBarScreen.mypage.route){
            mypageScreen()
        }
    }
}

fun NavHost(navController: NavController, startDestination: String, builder: NavGraphBuilder.() -> Unit) {

}
