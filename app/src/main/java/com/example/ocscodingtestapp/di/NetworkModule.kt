package com.example.ocscodingtestapp.di

import com.example.ocscodingtestapp.network.ApiService
import com.example.ocscodingtestapp.network.model.athlete.AthleteDtoMapper
import com.example.ocscodingtestapp.network.model.athleteResults.AthleteResultsDtoMapper
import com.example.ocscodingtestapp.network.model.game.GameDtoMapper
 import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn

import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule{
   const val baseUrl="https://test-ocs.herokuapp.com/"
    @Singleton
    @Provides
    fun provideAthleteMapper() :AthleteDtoMapper{
        return AthleteDtoMapper()
    }

    @Singleton
    @Provides
    fun provideAthleteResultsMapper() :AthleteResultsDtoMapper {
        return AthleteResultsDtoMapper()
    }

    @Singleton
    @Provides
    fun provideGameMapper() :GameDtoMapper{
        return GameDtoMapper()
    }




    @Singleton
    @Provides
    fun provideRecipeService() : ApiService{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(ApiService::class.java)
    }

}