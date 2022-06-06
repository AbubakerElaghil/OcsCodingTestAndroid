package com.example.ocscodingtestapp.repository.game

import com.example.ocscodingtestapp.domain.model.Athlete
import com.example.ocscodingtestapp.domain.model.AthleteResults
import com.example.ocscodingtestapp.domain.model.Game


interface GameRepository {
    suspend fun getGames(): List<Game>

}