package com.example.springapitest.presentation.components.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

object MainDestinations {
    const val PLAN_ROUTE = "plan"
    const val SHARE_ROUTE = "share"
    const val MYPAGE_ROUTE = "mypage"
    const val HOME_ROUTE = "home"
    const val PLAN_DETAIL_ROUTE = "plan_detail"
    const val SHARE_DETAIL_ROUTE = "share_detail"
    const val MYPAGE_DETAIL_ROUTE = "mypage_detail"
}

@Composable
fun rememberSAPINavController(
    navController: NavHostController = rememberNavController()
):SATNavController = remember(navController){
    SATNavController(navController)
}

@Stable
class SATNavController(
    val navController: NavHostController
) {
    val currentRoute : String?
        get() = navController.currentDestination?.route
    fun upPress(){
        navController.navigateUp()
    }
    fun navigateBottomBarRoute(route: String){
        if(route != currentRoute){
            navController.navigate(route){
                launchSingleTop = true //만약 현재 라우트가 이미 스택에 있으면 그 라우트를 최상위로 올린다.
                restoreState = true//현재 라우트가 스택에 있으면 그 라우트를 다시 복원한다.
                popUpTo(findStartDestitnation(navController.graph).id){//현재 라우트가 스택에 있으면 그 라우트를 다시 복원한다.
                    saveState = true//현재 라우트가 스택에 있으면 그 라우트를 다시 복원한다.
                }
            }
        }
    }
    fun navigateToSnackDetail(snackId: Long, from: NavBackStackEntry){
        if(from.lifecycleIsResumed()){
            navController.navigate("${MainDestinations.PLAN_ROUTE}/$snackId")
        }

    }
    private fun NavBackStackEntry.lifecycleIsResumed() = this.getLifecycle().currentState == Lifecycle.State.RESUMED

    private  val NavGraph.startDestination: NavDestination?
        get() = findNode(startDestinationId) //startDestinationId는 NavGraph의 프로퍼티이다.

    private fun findStartDestitnation(graph: NavDestination): NavDestination { //
        return if (graph is NavGraph) findStartDestitnation(graph.startDestination!!) else graph //graph가 NavGraph이면 graph.startDestination을 반환하고 아니면 graph를 반환한다.


    }
}