package com.aam.gmapextechnicalinterview.presentation.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.aam.gmapextechnicalinterview.R
import com.aam.gmapextechnicalinterview.presentation.view_model.MainViewModel
import com.aam.gmapextechnicalinterview.presentation.view_model.NavigationViewModel


/**
 * Composable that displays details of a single character.
 *
 * @param navigationViewModel ViewModel that manages navigation within the application.
 * @param remoteDataViewModel ViewModel that manages remote data for the application.
 */
@Composable
fun SingleCharactersScreen(
    navigationViewModel: NavigationViewModel,
    remoteDataViewModel: MainViewModel
) {
    val singleCharacter = remoteDataViewModel.characterDetail.collectAsState().value

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = rememberImagePainter(data = singleCharacter?.image),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black.copy(alpha = 0.8f))
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(color = Color.Black),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = rememberImagePainter(data = singleCharacter?.image),
                contentDescription = null,
                modifier = Modifier.size(200.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "${stringResource(R.string.single_char_name_text)}${singleCharacter?.name}")
            Text(text = "${stringResource(R.string.single_char_specie_text)}${singleCharacter?.species}")
            Text(text = "${stringResource(R.string.single_char_status_text)}${singleCharacter?.status}")
            Text(text = "${stringResource(R.string.single_char_genre_text)} ${singleCharacter?.gender}")
            Button(
                onClick = { navigationViewModel.backToList() },
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = stringResource(R.string.back_button_text))
            }
        }
    }


    //Manejo para la deteccion de tap en el boton back del dispositivo por parte del usuario.
    BackHandler {
        navigationViewModel.backToList()
    }
}
