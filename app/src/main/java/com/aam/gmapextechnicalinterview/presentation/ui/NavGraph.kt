package com.aam.gmapextechnicalinterview.presentation.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aam.gmapextechnicalinterview.data.model.ui.ScreensRoutes
import com.aam.gmapextechnicalinterview.presentation.ui.Colors.DarkColorScheme
import com.aam.gmapextechnicalinterview.presentation.ui.Colors.LightColorScheme
import com.aam.gmapextechnicalinterview.presentation.view_model.MainViewModel
import com.aam.gmapextechnicalinterview.presentation.view_model.NavigationViewModel
import kotlinx.coroutines.delay


/**
 * Composable that defines the main navigation structure of the application.
 *
 * @param navigationViewModel ViewModel that manages navigation within the application.
 */
@Composable
fun MainNavGraph(navigationViewModel: NavigationViewModel) {

    // Controlador de navegación de Compose.
    val navHostController = rememberNavController()

    /*
    * Estados de la UI
    * */
    val remoteDataViewModel: MainViewModel = hiltViewModel()
    val isLoading = remoteDataViewModel.isLoading.collectAsState().value
    val weGotAnError = remoteDataViewModel.weGotAnError.collectAsState().value
    navigationViewModel.navController = navHostController

    //Verificacion del Theme en el dispositivo.
    val isSystemInDarkTheme = isSystemInDarkTheme()

    val theme = if (isSystemInDarkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    CompositionLocalProvider(LocalContentColor provides theme.onSurface) {
        NavHost(
            navController = navHostController,
            startDestination = ScreensRoutes.CharacterList.route
        ) {

            //NavHost agrega el siguiente composable para generar un destino a la lista de perosnajes.
            composable(route = ScreensRoutes.CharacterList.route) {
                if (isLoading) {
                    LoadingScreen()
                    remoteDataViewModel.getCharactersList(null, null, null, null)
                } else if (weGotAnError.first) {
                    ErrorScreen(navigationViewModel, weGotAnError.second)
                } else
                    CharactersScreen(
                        navigationViewModel,
                        remoteDataViewModel
                    )
            }

            //NavHost agrega el siguiente composable para generar un destino a la pantalla para un unico personaje.
            composable(route = ScreensRoutes.CharacterDetail.route) {
                if (isLoading) {
                    LoadingScreen()
                    LaunchedEffect(Unit) {
                        delay(6000)
                    }
                } else if (weGotAnError.first) {
                    ErrorScreen(navigationViewModel, weGotAnError.second)
                } else
                    SingleCharactersScreen(
                        navigationViewModel,
                        remoteDataViewModel
                    )
            }
        }
    }
}