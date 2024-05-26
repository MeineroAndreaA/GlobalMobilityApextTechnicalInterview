package com.aam.gmapextechnicalinterview.presentation.ui

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
import java.util.Locale

@Composable
fun NameEntryDialog(
    showDialog: Boolean,
    onDismiss: () -> Unit,
    onConfirm: (String) -> Unit
) {

    var characterName by remember { mutableStateOf("") }

    if (showDialog) {
        AlertDialog(
            title = { Text("Ingresa el nombre del personaje") },
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
                    Text("Aceptar")
                }
            },
            dismissButton = {
                Button(
                    onClick = { onDismiss() }
                ) {
                    Text("Cancelar")
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

    if (showDialog) {
        AlertDialog(
            title = { Text("Selecciona el estado del personaje") },
            text = {
                Column {
                    TextButton(onClick = { statusSelected = "alive" }) {
                        Text(text = "Vivo")
                    }
                    TextButton(onClick = { statusSelected = "dead" }) {
                        Text(text = "Muerto")
                    }
                    TextButton(onClick = { statusSelected = "unknown" }) {
                        Text(text = "Desconocido")
                    }
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        onConfirm(statusSelected)
                    }
                ) {
                    Text("Aceptar")
                }
            },
            dismissButton = {
                Button(
                    onClick = { onDismiss() }
                ) {
                    Text("Cancelar")
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

    if (showDialog) {
        AlertDialog(
            title = { Text("Ingresa el nombre del personaje") },
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
                    Text("Aceptar")
                }
            },
            dismissButton = {
                Button(
                    onClick = { onDismiss() }
                ) {
                    Text("Cancelar")
                }
            },
            onDismissRequest = { onDismiss() }
        )
    }

}

val species = listOf(
    "Human",
    "Alien",
    "Humanoid",
    "Robot",
    "Mythological Creature",
    "Animal",
    "Unknown",
    "Poopybutthole",
    "Mythological Creature",
    "Cronenberg",
    "Cat",
    "Disease",
    "Demon",
    "Parasite",
    "Amoeba",
    "Self-aware arm",
    "Half-dragon",
    "Animal Person",
    "Dinosaur",
    "Hivemind"
)