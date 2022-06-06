package com.example.ocscodingtestapp.repository.game

 import com.example.ocscodingtestapp.domain.model.Game
import com.example.ocscodingtestapp.network.ApiService
 import com.example.ocscodingtestapp.network.model.game.GameDtoMapper

class GameRepositoryImpl(private val apiService: ApiService,private val gameDtoMapper: GameDtoMapper  ) : GameRepository {

    override suspend fun getGames(): List<Game> {
        return  gameDtoMapper.ToDomainList(apiService.getGames())
    }

}