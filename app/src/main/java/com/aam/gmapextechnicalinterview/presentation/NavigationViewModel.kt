package com.aam.gmapextechnicalinterview.presentation

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.aam.gmapextechnicalinterview.data.model.ui.ScreensRoutes
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

class NavigationViewModel: ViewModel() {

    lateinit var navController: NavController

    fun navigateToDetail() {
        navController.navigate(ScreensRoutes.CharacterDetail.route)
    }

    fun backToList() {
        navController.popBackStack()
        navController.navigate(ScreensRoutes.CharacterList.route)
    }
}