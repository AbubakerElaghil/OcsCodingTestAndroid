package com.example.ocscodingtestapp.network.model.game

import com.example.ocscodingtestapp.domain.model.Game
import com.example.ocscodingtestapp.domain.util.DomainMapper

class GameDtoMapper : DomainMapper<GameDto, Game> {

    /**
     * function to convert from network model to domain model ( Ui model)
     * Dto = Data transfer object
     */
    override fun mapToDomainModel(model: GameDto): Game {
        return Game(
            id = model.id,
            city = model.city,
            year = model.year
         )
    }

    /**
     * function to convert from domain model to network model
     * maybe will be used in the future if object are sent to the server...
     */
    override fun mapFromDomainModel(domainModel: Game): GameDto {

        return GameDto(
            id = domainModel.id,
            city = domainModel.city,
            year = domainModel.year
        )

    }

    fun ToDomainList(initial :List<GameDto> ): List<Game> {
        return initial.map { mapToDomainModel(it) }
    }
   fun fromDomainList(initial :List<Game> ): List<GameDto> {
        return initial.map { mapFromDomainModel(it) }
    }



}