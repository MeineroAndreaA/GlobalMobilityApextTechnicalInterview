package com.aam.gmapextechnicalinterview.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aam.gmapextechnicalinterview.presentation.MainViewModel
import com.aam.gmapextechnicalinterview.presentation.NavigationViewModel


@Composable
fun CharactersScreen(navigationViewModel: NavigationViewModel, remoteDataViewModel: MainViewModel) {

    val charactersList = remoteDataViewModel.listOfCharacter.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(charactersList!!.results.size) { index ->
                Item(character = charactersList.results[index])
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {  }
            ) {
                Text(text = "Anterior")
            }

            Button(onClick = {  }) {
                Text(text = "Siguiente")
            }
        }
    }
}
