package com.aam.gmapextechnicalinterview.presentation

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

    fun getCharactersList(pages: Int?) {
        viewModelScope.launch {
            when (val response = remoteRepository.getCharacters(pages)) {
                is RndMNetworkResult.Success -> {
                    character.value = response.data
                    loading.value = false
                }

                is RndMNetworkResult.Error -> {
                    error.value = Pair(true, "")
                    loading.value = false

                }
                is RndMNetworkResult.Exception -> {
                    error.value = Pair(true, response.e.localizedMessage?.toString() ?: "")
                    loading.value = false
                }
            }
        }
    }

    fun getSingleCharacter(id: Int) {
        viewModelScope.launch {
            loading.value = true
            when (val response = remoteRepository.getSingleCharacter(id)) {
                is RndMNetworkResult.Success -> {
                    loading.value = false
                    singleCharacter.value = response.data
                }

                is RndMNetworkResult.Error -> {
                    loading.value = false
                    error.value = Pair(true, "")

                }
                is RndMNetworkResult.Exception -> {
                    loading.value = false
                    error.value = Pair(true, response.e.localizedMessage?.toString() ?: "")
                }
            }

        }
    }

}