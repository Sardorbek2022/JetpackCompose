package mr.sardorek.jetpackapp.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import mr.sardorek.jetpackapp.home.MainScreen
import mr.sardorek.jetpackapp.util.Graph

@Composable
fun RootNavigation(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        route = Graph.ROOT,
        startDestination = Graph.SPLASH
    ) {
        splashNavGraph(navHostController = navHostController)
        composable(route = Graph.MAIN) {
            MainScreen()
        }
    }
}