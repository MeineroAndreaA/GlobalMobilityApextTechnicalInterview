package com.aam.gmapextechnicalinterview.presentation.ui

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.aam.gmapextechnicalinterview.data.core.RetrofitModule
import com.aam.gmapextechnicalinterview.domain.RemoteDataSource
import com.aam.gmapextechnicalinterview.presentation.MainViewModel
import com.aam.gmapextechnicalinterview.presentation.NavigationViewModel


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
                .background(color = Color.Black.copy(alpha = 0.5f))
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = rememberImagePainter(data = singleCharacter?.image),
                contentDescription = null,
                modifier = Modifier.size(200.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Nombre: ${singleCharacter?.name}")
            Text(text = "Especie: ${singleCharacter?.species}")
            Text(text = "Estatus: ${singleCharacter?.status}")
            Text(text = "Genero: ${singleCharacter?.gender}")
            Button(
                onClick = { navigationViewModel.backToList() },
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = "Volver")
            }
        }
    }
}
