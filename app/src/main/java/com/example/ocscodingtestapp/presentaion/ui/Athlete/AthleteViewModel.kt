package com.example.ocscodingtestapp.presentaion.ui.Athlete

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ocscodingtestapp.domain.model.Athlete
import com.example.ocscodingtestapp.domain.model.Game
import com.example.ocscodingtestapp.repository.AthleteRepository
import com.example.ocscodingtestapp.repository.game.GameRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AthleteViewModel @Inject constructor(private val athleteRepository: AthleteRepository) :
    ViewModel() {

    val athlete: MutableState<Athlete?> = mutableStateOf(null)

    val loading = mutableStateOf(false)


    public fun getAthleteDetails(id: String) {
        viewModelScope.launch {
            loading.value = true
            val athleteDetail = athleteRepository.getAthleteDetail(id.toInt())
            getAthleteResults(athleteDetail)
            athlete.value = athleteDetail
            loading.value = false
        }
    }

    private suspend fun getAthleteResults(athlete: Athlete) {
        athlete.id?.let {
            athlete.results = athleteRepository.getAthleteResults(it.toInt())
        }


    }

}