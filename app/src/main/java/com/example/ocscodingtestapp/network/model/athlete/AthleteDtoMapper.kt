package com.example.ocscodingtestapp.network.model.athlete

 import com.example.ocscodingtestapp.domain.model.Athlete
import com.example.ocscodingtestapp.domain.util.DomainMapper
  import com.example.ocscodingtestapp.util.getAthletePhotoUrl
 import javax.inject.Inject
import javax.inject.Named

class AthleteDtoMapper : DomainMapper<AthleteDto, Athlete> {

    /**
     * function to convert from network model to domain model ( Ui model)
     * Dto = Data transfer object
     */
    override fun mapToDomainModel(model: AthleteDto ): Athlete {

        return Athlete(
            id = model.id,
            name = model.name,
            surname = model.surname,
            dateOfBirth = model.dateOfBirth,
            bio = model.bio,
            weight = model.weight,
            height = model.height,
             photoId = model.photoId,
            photoUrl = model.photoId?.let { getAthletePhotoUrl(it) }

         )
    }

    /**
     * function to convert from domain model to network model
     * maybe will be used in the future if object are sent to the server...
     */
    override fun mapFromDomainModel(domainModel: Athlete): AthleteDto {

        return AthleteDto(
            id = domainModel.id,
            name = domainModel.name,
            surname = domainModel.surname,
            dateOfBirth = domainModel.dateOfBirth,
            bio = domainModel.bio,
            weight = domainModel.weight,
            height = domainModel.height,
            photoId = domainModel.photoId
        )

    }

    fun ToDomainList(initial :List<AthleteDto> ): List<Athlete> {
        return initial.map { mapToDomainModel(it) }
    }
   fun fromDomainList(initial :List<Athlete> ): List<AthleteDto> {
        return initial.map { mapFromDomainModel(it) }
    }



}