package com.aam.gmapextechnicalinterview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.aam.gmapextechnicalinterview.presentation.NavigationViewModel
import com.aam.gmapextechnicalinterview.presentation.ui.MainNavGraph

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navigationViewModel : NavigationViewModel by viewModels()

        setContent { MainNavGraph(navigationViewModel) }
    }
}