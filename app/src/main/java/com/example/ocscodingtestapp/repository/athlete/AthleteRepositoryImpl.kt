package com.example.ocscodingtestapp.repository

import com.example.ocscodingtestapp.domain.model.Athlete
import com.example.ocscodingtestapp.domain.model.AthleteResults
import com.example.ocscodingtestapp.network.ApiService
import com.example.ocscodingtestapp.network.model.athlete.AthleteDtoMapper
import com.example.ocscodingtestapp.network.model.athleteResults.AthleteResultsDtoMapper

 class AthleteRepositoryImpl(private val apiService: ApiService,private val  athleteMapper: AthleteDtoMapper,private val athleteResultsMapper: AthleteResultsDtoMapper ) : AthleteRepository {

   override suspend fun getGamesAthletes(id: Int): List<Athlete> {
      return athleteMapper.ToDomainList(apiService.getAthletesByGame(id))
    }

    override suspend fun getAthleteDetail(id: Int): Athlete {
        return athleteMapper.mapToDomainModel(apiService.getAthleteDetail(id))
    }

    override suspend fun getAthleteResults(id: Int): List<AthleteResults> {
        return athleteResultsMapper.ToDomainList(apiService.getAthleteResults(id))
    }

}