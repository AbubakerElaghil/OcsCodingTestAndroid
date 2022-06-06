package com.example.ocscodingtestapp.di

import com.example.ocscodingtestapp.network.ApiService
import com.example.ocscodingtestapp.network.model.athlete.AthleteDtoMapper
import com.example.ocscodingtestapp.network.model.athleteResults.AthleteResultsDtoMapper
import com.example.ocscodingtestapp.network.model.game.GameDtoMapper
import com.example.ocscodingtestapp.repository.AthleteRepository
import com.example.ocscodingtestapp.repository.AthleteRepositoryImpl
import com.example.ocscodingtestapp.repository.game.GameRepository
import com.example.ocscodingtestapp.repository.game.GameRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule{


   @Singleton
    @Provides
    fun provideAthleteRepository(apiService: ApiService, athleteMapper: AthleteDtoMapper, athleteResultsMapper: AthleteResultsDtoMapper ) :AthleteRepository{
        return AthleteRepositoryImpl(apiService,athleteMapper,athleteResultsMapper )
    }

   @Singleton
    @Provides
    fun provideGameRepository(apiService: ApiService,   gameMapper: GameDtoMapper) :GameRepository{
        return GameRepositoryImpl(apiService, gameMapper)
    }




}