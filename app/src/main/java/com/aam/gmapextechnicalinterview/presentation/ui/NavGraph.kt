package com.aam.gmapextechnicalinterview.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
    val isLoading = remoteDataViewModel.isLoading.collectAsState().value
    val weGotAnError = remoteDataViewModel.weGotAnError.collectAsState().value


    NavHost(
        navController = navHostController,
        startDestination = ScreensRoutes.CharacterList.route
    ) {
        composable(route = ScreensRoutes.CharacterList.route) {
            if (isLoading) {
                LoadingScreen(navigationViewModel, remoteDataViewModel)
                remoteDataViewModel.getCharactersList(null)
            } else if (weGotAnError.first) {
                ErrorScreen(weGotAnError.second)
            } else
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