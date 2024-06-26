package com.aam.gmapextechnicalinterview.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.aam.gmapextechnicalinterview.data.model.response.Results

/**
 * Composable that populates the character list.
 *
 * @param character Data of the character to be displayed.
 * @param onItemClick Action to perform when the item is clicked.
 */
@Composable
fun Item(character: Results, onItemClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onItemClick() }
    ) {
        Image(
            painter = rememberImagePainter(data = character.image),
            contentDescription = null,
            modifier = Modifier.size(64.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = character.name,
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}