package com.example.ocscodingtestapp.network

 import com.example.ocscodingtestapp.network.model.athlete.AthleteDto
import com.example.ocscodingtestapp.network.model.athleteResults.AthleteResultsDto
import com.example.ocscodingtestapp.network.model.game.GameDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("games")
    suspend fun getGames(): List<GameDto>

    @GET("games/{game_id}/athletes")
    suspend fun getAthletesByGame(@Path("game_id") id:Int,): List<AthleteDto>

    @GET("athletes/{athlete_id}")
    suspend fun getAthleteDetail( @Path("athlete_id") id:Int,): AthleteDto


    @GET("athletes/{athlete_id}/results")
    suspend fun getAthleteResults( @Path("athlete_id") id:Int,): List<AthleteResultsDto>

}