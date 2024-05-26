package com.aam.gmapextechnicalinterview.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.aam.gmapextechnicalinterview.R
import com.aam.gmapextechnicalinterview.presentation.view_model.MainViewModel
import com.aam.gmapextechnicalinterview.presentation.view_model.NavigationViewModel
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

/**
 * Composable that displays an error screen with a message and a button to retry.
 *
 * @param navigationViewModel Navigation ViewModel used to control navigation.
 * @param errorMessage Error message to be displayed on the screen.
 */
@Composable
fun ErrorScreen(
    navigationViewModel: NavigationViewModel,
    errorMessage: String
) {

    val composition by rememberLottieComposition(LottieCompositionSpec.Asset("error.json"))
    val progress by animateLottieCompositionAsState(composition = composition)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        LottieAnimation(
            composition = composition,
            progress = progress,
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = errorMessage,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { navigationViewModel.backToList() }
        ) {
            Text(text = stringResource(R.string.retry_button_text))
        }
    }
}