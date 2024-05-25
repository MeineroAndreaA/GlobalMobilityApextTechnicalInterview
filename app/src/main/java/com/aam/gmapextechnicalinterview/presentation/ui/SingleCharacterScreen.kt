package com.aam.gmapextechnicalinterview.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aam.gmapextechnicalinterview.presentation.MainViewModel
import com.aam.gmapextechnicalinterview.presentation.NavigationViewModel


@Composable
fun SingleCharactersScreen(
    navigationViewModel: NavigationViewModel,
    remoteDataViewModel: MainViewModel
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { navigationViewModel.backToList(null) },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Volvamos a la lista")
        }
    }
}