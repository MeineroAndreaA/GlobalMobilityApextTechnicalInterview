package com.aam.gmapextechnicalinterview.presentation.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.aam.gmapextechnicalinterview.R
import com.aam.gmapextechnicalinterview.presentation.ui.dialogs.NameEntryDialog
import com.aam.gmapextechnicalinterview.presentation.ui.dialogs.SpeciesEndtryDialog
import com.aam.gmapextechnicalinterview.presentation.ui.dialogs.StatusSelectionDialog
import com.aam.gmapextechnicalinterview.presentation.utils.CleanUpPaginationUrlUtils.cleanUpPageCount
import com.aam.gmapextechnicalinterview.presentation.utils.CleanUpPaginationUrlUtils.cleanUpPageNumber
import com.aam.gmapextechnicalinterview.presentation.view_model.MainViewModel
import com.aam.gmapextechnicalinterview.presentation.view_model.NavigationViewModel

/**
 * Composable to display a list of characters, whether filtered or not.
 * @param navigationViewModel Provides navigation functionalities using the [JetpackNavigation] library.
 * @param remoteDataViewModel Provides functionalities to asynchronously execute API calls.
 */
@Composable
fun CharactersScreen(navigationViewModel: NavigationViewModel, remoteDataViewModel: MainViewModel) {

    //Toma el listado en cache
    val charactersList = remoteDataViewModel.listOfCharacter.collectAsState().value

    /*
    * Estados de los dialogos y de las selecciones en los filtros
    * */
    var showDialogName by remember { mutableStateOf(false) }
    var showDialogStatus by remember { mutableStateOf(false) }
    var showDialogSpecies by remember { mutableStateOf(false) }
    var stateOfName by remember { mutableStateOf<String?>(null) }
    var stateOfStatus by remember { mutableStateOf<String?>(null) }
    var stateOfSpecies by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        //Botones de fitros
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(modifier = Modifier.weight(1f), onClick = { showDialogName = true }) {
                (Text(text = stringResource(R.string.name_filter_button_text)))
            }
            Spacer(modifier = Modifier.width(5.dp))
            Button(modifier = Modifier.weight(1f), onClick = { showDialogStatus = true }) {
                (Text(text = stringResource(R.string.status_filter_button_text)))
            }
            Spacer(modifier = Modifier.width(5.dp))
            Button(modifier = Modifier.weight(1f), onClick = { showDialogSpecies = true }) {
                (Text(text = stringResource(R.string.species_filter_button_text)))
            }
        }

        //Listado de personajes
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(charactersList!!.results.size) { index ->
                Item(character = charactersList.results[index], onItemClick = {
                    remoteDataViewModel.getSingleCharacter(charactersList.results[index].id)
                    navigationViewModel.navigateToDetail()
                })
            }
        }

        //Botones para el manejo del paginado.
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                enabled = if (charactersList?.info!!.prev.isNullOrBlank()) false else true,
                colors = ButtonColors(
                    containerColor = Colors.Purple40,
                    contentColor = Color.White,
                    disabledContainerColor = Colors.greyDisabled,
                    disabledContentColor = Color.White,
                ),
                onClick = {
                    val page = cleanUpPageNumber(
                        charactersList.info.prev.toString()
                    )
                    remoteDataViewModel.getCharactersList(
                        page,
                        stateOfName,
                        stateOfStatus,
                        stateOfSpecies
                    )
                }
            ) {
                Text(text = stringResource(R.string.prev_button_text))
            }

            //Contador de paginas.
            Text(
                modifier = Modifier.align(Alignment.CenterVertically),
                text = stringResource(
                    R.string.cont_pages_text,
                    cleanUpPageCount(charactersList.info)
                )
            )

            Button(
                enabled = if (charactersList.info.next.isNullOrBlank()) false else true,
                colors = ButtonColors(
                    containerColor = Colors.Purple40,
                    contentColor = Color.White,
                    disabledContainerColor = Colors.greyDisabled,
                    disabledContentColor = Color.White,
                ),
                onClick = {
                    val page = cleanUpPageNumber(
                        charactersList.info.next.toString()
                    )
                    remoteDataViewModel.getCharactersList(
                        page, stateOfName, stateOfStatus, stateOfSpecies
                    )
                }) {
                Text(text = stringResource(R.string.next_button_text))
            }
        }
    }

    //Instancia de los dialogos, donde se llama a la API para que filtre los resultados de la lista.
    NameEntryDialog(
        showDialog = showDialogName,
        onDismiss = { showDialogName = false },
        onConfirm = { name ->
            showDialogName = false
            stateOfName = name
            stateOfStatus = null
            stateOfSpecies = null
            remoteDataViewModel.getCharacterByName(
                null,
                name
            )
        })

    StatusSelectionDialog(
        showDialog = showDialogStatus,
        onDismiss = { showDialogStatus = false },
        onConfirm = { status ->
            showDialogStatus = false
            stateOfStatus = status
            stateOfName = null
            stateOfSpecies = null
            remoteDataViewModel.getCharacterByStatus(
                null,
                status
            )
        })

    SpeciesEndtryDialog(
        showDialog = showDialogSpecies,
        onDismiss = { showDialogSpecies = false },
        onConfirm = { specie ->
            showDialogSpecies = false
            stateOfSpecies = specie
            stateOfName = null
            stateOfStatus = null
            remoteDataViewModel.getCharacterBySpecie(null, specie)
        })

    BackHandler {
        navigationViewModel.navController.popBackStack()
    }
}



