package com.example.ocscodingtestapp.network.model.athleteResults

import com.example.ocscodingtestapp.domain.model.AthleteResults
import com.example.ocscodingtestapp.domain.util.DomainMapper

class AthleteResultsDtoMapper : DomainMapper<AthleteResultsDto, AthleteResults> {

    /**
     * function to convert from network model to domain model ( Ui model)
     * Dto = Data transfer object
     */
    override fun mapToDomainModel(model: AthleteResultsDto): AthleteResults {
        return AthleteResults(
            city = model.city,
            year = model.year,
            gold = model.gold,
            silver = model.silver,
            bronze = model.bronze,
         )
    }

    /**
     * function to convert from domain model to network model
     * maybe will be used in the future if object are sent to the server...
     */
    override fun mapFromDomainModel(domainModel: AthleteResults): AthleteResultsDto {

        return AthleteResultsDto(
            city = domainModel.city,
            year = domainModel.year,
            gold = domainModel.gold,
            silver = domainModel.silver,
            bronze = domainModel.bronze,
        )

    }

    fun ToDomainList(initial :List<AthleteResultsDto> ): List<AthleteResults> {
        return initial.map { mapToDomainModel(it) }
    }
   fun fromDomainList(initial :List<AthleteResults> ): List<AthleteResultsDto> {
        return initial.map { mapFromDomainModel(it) }
    }



}