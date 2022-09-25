package com.example.gameslist.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gameslist.data.GamesRepository
import com.example.gameslist.data.remote.GamesResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class GamesViewModel(
    private val gamesRepository: GamesRepository
) : ViewModel() {

    private val _gamesListState = MutableStateFlow(listOf(GamesResponse(title = "", thumbnail = "", platform = "")))
    val gamesListState = _gamesListState.asStateFlow()

    fun getGamesList(platform: String) {
        viewModelScope.launch {
            val response = gamesRepository.getGamesList(platform)
            gamesListState.collect {
                if (response.isSuccessful) {
                    response.body()?.let {
                        _gamesListState.value = it
                    }
                } else {
                    Log.e(fetchError, response.message().toString())
                }
            }
        }
    }

    companion object {
        const val fetchError = "Error when fetching"
    }
}
