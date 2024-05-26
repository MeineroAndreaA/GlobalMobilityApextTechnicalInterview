package com.aam.gmapextechnicalinterview.presentation.view_model

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.aam.gmapextechnicalinterview.data.model.ui.ScreensRoutes

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