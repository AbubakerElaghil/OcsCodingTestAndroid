package com.example.ocscodingtestapp.presentaion.ui.games_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ocscodingtestapp.domain.model.Game
import com.example.ocscodingtestapp.repository.AthleteRepository
import com.example.ocscodingtestapp.repository.game.GameRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameListViewModel @Inject constructor(private val gameRepository: GameRepository,private val athleteRepository : AthleteRepository):ViewModel() {

    val games : MutableState<List<Game>> = mutableStateOf(listOf())
    val loading = mutableStateOf(false)

    init {
        getGames()
    }

    private fun getGames() {
        viewModelScope.launch {
            loading.value=true
            val gamesList = gameRepository.getGames()
            getGamesAthletes(gamesList)
            games.value = gamesList
            loading.value=false
        }
    }

    private suspend fun getGamesAthletes(gamesList: List<Game>) {
        for (game in gamesList){
            game.id?.let { gameId ->
                val athleteList = athleteRepository.getGamesAthletes(gameId)
                game.athletesList= athleteList
            }
        }
    }

}