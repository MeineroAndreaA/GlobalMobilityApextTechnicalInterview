package com.aam.gmapextechnicalinterview.presentation.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aam.gmapextechnicalinterview.data.model.ui.ScreensRoutes
import com.aam.gmapextechnicalinterview.presentation.MainViewModel
import com.aam.gmapextechnicalinterview.presentation.NavigationViewModel

@Composable
fun MainNavGraph(navigationViewModel: NavigationViewModel) {
    val remoteDataViewModel: MainViewModel = hiltViewModel()
    val navHostController = rememberNavController()
    navigationViewModel.navController = navHostController

    NavHost(
        navController = navHostController,
        startDestination = ScreensRoutes.CharacterList.route
    ) {
        composable(route = ScreensRoutes.CharacterList.route) {
            CharactersScreen(
                navigationViewModel,
                remoteDataViewModel
            )
        }
        composable(route = ScreensRoutes.CharacterDetail.route) {
            SingleCharactersScreen(
                navigationViewModel,
                remoteDataViewModel
            )
        }
    }
}