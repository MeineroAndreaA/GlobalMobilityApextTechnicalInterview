package com.aam.gmapextechnicalinterview.presentation.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aam.gmapextechnicalinterview.data.model.ui.ScreensRoutes
import com.aam.gmapextechnicalinterview.presentation.NavigationViewModel

@Composable
fun MainNavGraph(navigationViewModel: NavigationViewModel) {
    val navHostController = rememberNavController()
    navigationViewModel.navController = navHostController
    NavHost(
        navController = navHostController,
        startDestination = ScreensRoutes.CharacterList.route
    ) {
        composable(route = ScreensRoutes.CharacterList.route) {
            CharactersScreen(
                navigationViewModel
            )
        }
        composable(route = ScreensRoutes.CharacterDetail.route) {
            SingleCharactersScreen(
                navigationViewModel
            )
        }
    }
}