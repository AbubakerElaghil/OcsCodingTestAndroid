package com.example.ocscodingtestapp.repository

import com.example.ocscodingtestapp.domain.model.Athlete
import com.example.ocscodingtestapp.domain.model.AthleteResults


interface AthleteRepository {
    suspend fun getGamesAthletes(id:Int): List<Athlete>
    suspend fun getAthleteDetail(id:Int): Athlete
    suspend fun getAthleteResults(id:Int): List<AthleteResults>

}