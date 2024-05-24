package com.aam.gmapextechnicalinterview.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aam.gmapextechnicalinterview.data.model.response.Character
import com.aam.gmapextechnicalinterview.data.model.response.Results
import com.aam.gmapextechnicalinterview.domain.RemoteDataSource
import com.aam.gmapextechnicalinterview.domain.RndMNetworkResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val remoteRepository: RemoteDataSource) : ViewModel() {

    private val character = MutableStateFlow<Character?>(null)
    val listOfCharacter: StateFlow<Character?> = character

    private val singleCharacter = MutableStateFlow<Results?>(null)
    val characterDetail: StateFlow<Results?> = singleCharacter

    private val loading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = loading

    fun getCharactersList(pages: Int?) {
        viewModelScope.launch {
            loading.value = true
            when (val response = remoteRepository.getCharacters(pages)) {
                is RndMNetworkResult.Success -> {
                    loading.value = false
                }

                is RndMNetworkResult.Error -> {}
                is RndMNetworkResult.Exception -> {}
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

                is RndMNetworkResult.Error -> {}
                is RndMNetworkResult.Exception -> {}
            }

        }
    }

}