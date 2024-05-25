package com.aam.gmapextechnicalinterview.data.model.ui

sealed class ScreensRoutes (val route: String) {
    data object CharacterList : ScreensRoutes("characterList")
    data object CharacterDetail : ScreensRoutes("singleCharacter")
}