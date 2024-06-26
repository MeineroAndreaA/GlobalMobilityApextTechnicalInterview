package com.aam.gmapextechnicalinterview

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.aam.gmapextechnicalinterview.presentation.ui.MainNavGraph
import com.aam.gmapextechnicalinterview.presentation.view_model.NavigationViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val navigationViewModel: NavigationViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainNavGraph(navigationViewModel)
        }
    }
}