package com.aam.gmapextechnicalinterview.presentation.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aam.gmapextechnicalinterview.data.model.response.Character
import com.aam.gmapextechnicalinterview.data.model.response.Results
import com.aam.gmapextechnicalinterview.domain.RemoteDataSource
import com.aam.gmapextechnicalinterview.domain.RndMNetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val remoteRepository: RemoteDataSource) :
    ViewModel() {

    private val character = MutableStateFlow<Character?>(null)
    val listOfCharacter: StateFlow<Character?> = character

    private val singleCharacter = MutableStateFlow<Results?>(null)
    val characterDetail: StateFlow<Results?> = singleCharacter

    private val loading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = loading

    private val error = MutableStateFlow(Pair(false, ""))
    val weGotAnError: StateFlow<Pair<Boolean, String>> = error

    fun getCharactersList(pages: Int?, name: String?, status: String?, specie: String?) {
        viewModelScope.launch {
            when (val response = remoteRepository.getCharacters(pages, name, status, specie)) {
                is RndMNetworkResult.Success -> {
                    character.value = response.data
                    loading.value = false
                }

                is RndMNetworkResult.Error -> {}
                is RndMNetworkResult.Exception -> {
                    error.value = Pair(true, ErrorTextHelpers.ERROR_API.error_mesage)
                    loading.value = false
                }
            }
        }
    }


    fun getCharacterByName(pages: Int?, name: String) {
        viewModelScope.launch {
            when (val response = remoteRepository.getCharacters(pages, name, null, null)) {
                is RndMNetworkResult.Success -> {
                    character.value = response.data
                    loading.value = false
                }

                is RndMNetworkResult.Error -> {
                    error.value =
                        Pair(true, ErrorTextHelpers.ERROR_CHARACTER_NOT_FOUND.error_mesage)
                    loading.value = false

                }

                is RndMNetworkResult.Exception -> {
                    error.value = Pair(true, ErrorTextHelpers.ERROR_API.error_mesage)
                    loading.value = false
                }
            }
        }
    }

    fun getCharacterByStatus(pages: Int?, status: String) {
        viewModelScope.launch {
            when (val response = remoteRepository.getCharacters(pages, null, status, null)) {
                is RndMNetworkResult.Success -> {
                    character.value = response.data
                    loading.value = false
                }

                is RndMNetworkResult.Error -> {}

                is RndMNetworkResult.Exception -> {
                    error.value = Pair(true, ErrorTextHelpers.ERROR_API.error_mesage)
                    loading.value = false
                }
            }
        }
    }

    fun getCharacterBySpecie(pages: Int?, specie: String) {
        viewModelScope.launch {
            when (val response = remoteRepository.getCharacters(pages, null, null, specie)) {
                is RndMNetworkResult.Success -> {
                    character.value = response.data
                    loading.value = false
                }

                is RndMNetworkResult.Error -> {
                    error.value = Pair(true, ErrorTextHelpers.ERROR_SPECIES_NOT_FOUND.error_mesage)
                    loading.value = false

                }

                is RndMNetworkResult.Exception -> {
                    error.value = Pair(true, ErrorTextHelpers.ERROR_API.error_mesage)
                    loading.value = false
                }
            }
        }
    }

    fun getSingleCharacter(id: Int) {
        viewModelScope.launch {
            when (val response = remoteRepository.getSingleCharacter(id)) {
                is RndMNetworkResult.Success -> {
                    singleCharacter.value = response.data
                    loading.value = false
                }

                is RndMNetworkResult.Error -> {}
                is RndMNetworkResult.Exception -> {
                    error.value = Pair(true, ErrorTextHelpers.ERROR_API.error_mesage)
                    loading.value = false
                }
            }

        }
    }
}