package com.example.springapitest.presentation.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.springapitest.presentation.components.navigation.MainDestinations
import com.example.springapitest.presentation.components.navigation.SATNavController
import com.example.springapitest.presentation.components.navigation.rememberSAPINavController
import com.example.springapitest.ui.theme.SpringApiTestTheme

@Composable
fun IronBirdApp() {
    SpringApiTestTheme {
        val SATNavController = rememberSAPINavController()
        NavHost(
            navController = SATNavController.navController,
            startDestination = MainDestinations.HOME_ROUTE
        ){

        }
    }
}
private fun NavGraphBuilder.SAPINavGraph(
    onSnackSelected : (Long, NavBackStackEntry) -> Unit,
    upPress: () -> Unit,
    onNavigateToRoute : (String) -> Unit
) {
//    navigation(route = MainDestinations.HOME_ROUTE, startDestination = HomeSections.FEED.route){
//        addHomeGraph(
//            onSnackSelected = onSnackSelected,
//            onNavigateToRoute = onNavigateToRoute
//        )
//    }
    composable("${MainDestinations.PLAN_DETAIL_ROUTE}/{${MainDestinations.PLAN_ROUTE}}",
        arguments = listOf(navArgument(MainDestinations.PLAN_ROUTE){type = NavType.LongType})){
        val arguments = requireNotNull(it.arguments)
        val planId = arguments.getLong(MainDestinations.PLAN_ROUTE)



    }

}