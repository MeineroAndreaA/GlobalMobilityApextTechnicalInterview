package com.aam.gmapextechnicalinterview.presentation.ui.dialogs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import com.aam.gmapextechnicalinterview.R
import java.util.Locale

/**
 * The following dialogs belong to the filters for: Name, Species, and Status,
 * where the user can input the character's name or select an option.
 *
 * @param showDialog Flag indicating whether the dialog is currently shown, managed via StateCompose.
 * @param onDismiss Method indicating what to do when dismissing the dialog.
 * @param onConfirm Method capturing the written/selected value from the dialog.
 */
@Composable
fun NameEntryDialog(
    showDialog: Boolean,
    onDismiss: () -> Unit,
    onConfirm: (String) -> Unit
) {

    var characterName by remember { mutableStateOf("") }

    if (showDialog) {
        AlertDialog(
            title = { Text(stringResource(R.string.entry_name_dialog_text)) },
            text = {
                Column {
                    TextField(value = characterName, onValueChange = { characterName = it })
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        onConfirm(characterName)
                    }
                ) {
                    Text(stringResource(R.string.accept_button_text))
                }
            },
            dismissButton = {
                Button(
                    onClick = { onDismiss() }
                ) {
                    Text(stringResource(R.string.cancel_button_text))
                }
            },
            onDismissRequest = { onDismiss() }
        )
    }

}

@Composable
fun StatusSelectionDialog(
    showDialog: Boolean,
    onDismiss: () -> Unit,
    onConfirm: (String) -> Unit
) {

    var statusSelected by remember { mutableStateOf("") }
    val realStatuses = stringArrayResource(id = R.array.statuses)

    if (showDialog) {
        AlertDialog(
            title = { Text(stringResource(R.string.select_status_dialog_text)) },
            text = {
                Column {
                    TextButton(onClick = { statusSelected = realStatuses[0] }) {
                        Text(text = stringResource(R.string.status_alive_text))
                    }
                    TextButton(onClick = { statusSelected = realStatuses[1] }) {
                        Text(text = stringResource(R.string.status_dead_text))
                    }
                    TextButton(onClick = { statusSelected = realStatuses[2] }) {
                        Text(text = stringResource(R.string.status_unknow_text))
                    }
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        onConfirm(statusSelected)
                    }
                ) {
                    Text(stringResource(R.string.accept_button_text))
                }
            },
            dismissButton = {
                Button(
                    onClick = { onDismiss() }
                ) {
                    Text(stringResource(R.string.cancel_button_text))
                }
            },
            onDismissRequest = { onDismiss() }
        )
    }

}

@Composable
fun SpeciesEndtryDialog(
    showDialog: Boolean,
    onDismiss: () -> Unit,
    onConfirm: (String) -> Unit
) {

    var specieSelected by remember { mutableStateOf("") }
    val species = stringArrayResource(id = R.array.races)

    if (showDialog) {
        AlertDialog(
            title = { Text(stringResource(R.string.select__species_dialog_text)) },
            text = {
                Column {
                    LazyColumn {
                        items(species.size)
                        {
                            TextButton(onClick = {
                                specieSelected =
                                    species[it].lowercase(Locale.getDefault())
                            }) {
                                Text(text = species[it])
                            }
                        }
                    }
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        onConfirm(specieSelected)
                    }
                ) {
                    Text(stringResource(R.string.accept_button_text))
                }
            },
            dismissButton = {
                Button(
                    onClick = { onDismiss() }
                ) {
                    Text(stringResource(R.string.cancel_button_text))
                }
            },
            onDismissRequest = { onDismiss() }
        )
    }

}

