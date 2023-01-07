package mr.sardorek.jetpackapp.screen

import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import mr.sardorek.jetpackapp.bottom.FavoriteScreen
import mr.sardorek.jetpackapp.bottom.HomeScreen
import mr.sardorek.jetpackapp.bottom.ProfileScreen
import mr.sardorek.jetpackapp.bottom.SearchScreen
import mr.sardorek.jetpackapp.home.DetailScreen
import mr.sardorek.jetpackapp.splash.SplashScreen
import mr.sardorek.jetpackapp.util.Graph


fun NavGraphBuilder.splashNavGraph(navHostController: NavHostController) {
    navigation(
        route = Graph.SPLASH,
        startDestination = "SPLASH"
    ) {
        composable(
            route = "SPLASH"
        ) {
            SplashScreen(navHostController)
        }
    }
}

@Composable
fun MainNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        route = Graph.MAIN,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen(navHostController)
        }
        composable(route = BottomBarScreen.Search.route) {
            SearchScreen(navHostController)
        }
        composable(route = BottomBarScreen.Favorite.route) {
            FavoriteScreen(navHostController)
        }
        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen(navHostController)
        }
        detailsNavGraph(navHostController)
    }
}

fun NavGraphBuilder.detailsNavGraph(navHostController: NavHostController) {
    navigation(
        route = "${Graph.DETAILS}/{title}",
        startDestination = "DETAILS"
    ) {
        composable(
            route = "DETAILS",
            arguments = listOf(
                navArgument(
                    name = "title"
                ) {
                    type = NavType.StringType
                }
            )
        ) {
            val title = it.arguments?.getString("title") ?: "No data"
            DetailScreen(navHostController = navHostController, title)
        }
    }
}