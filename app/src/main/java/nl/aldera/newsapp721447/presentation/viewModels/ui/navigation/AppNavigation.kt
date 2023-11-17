package nl.aldera.newsapp721447.presentation.viewModels.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import nl.aldera.newsapp721447.presentation.viewModels.ui.pages.AccountPage
import nl.aldera.newsapp721447.presentation.viewModels.ui.pages.ArticleDetailsPage
import nl.aldera.newsapp721447.presentation.viewModels.ui.pages.ArticlesPage
import nl.aldera.newsapp721447.presentation.viewModels.ui.pages.FavoritesPage

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "articles"
    ) {
        composable("articles") {
            ArticlesPage(
                onItemClick = {
                    navController.navigate("articles/${it.Id}")
                },
                navController = navController
            )
        }
        composable(
            route = "articles/{Id}",
            arguments = listOf(
                navArgument("Id") {type = NavType.IntType}
            )
        ) {
            ArticleDetailsPage(
                Id = it.arguments?.getInt("Id") ?: -1,
                navController = navController
            ) {
                navController.popBackStack()
            }
        }
        composable(
            route = "favorites",
            arguments = listOf(
                navArgument("username") {type = NavType.StringType},
                navArgument("token") {type = androidx.navigation.NavType.StringType}
            )
        ) {
            FavoritesPage(
                navController = navController,
//                username = it.arguments?.getString("username") ?: ""
            )
        }
        composable(
            route = "account",
        ) {
            AccountPage(
                navController = navController
//                username = it.arguments?.getString("username") ?: ""
            )
        }
    }
}