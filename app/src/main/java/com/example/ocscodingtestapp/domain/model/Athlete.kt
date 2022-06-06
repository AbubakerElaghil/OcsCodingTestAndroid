package com.example.ocscodingtestapp.domain.model

/**
 *  domain model (UI model ) that will be used for views
 *  this class is for Athlete data
 */
data class Athlete(
    val id : String?=null,
    val name : String?=null,
    val surname : String?=null,
    val dateOfBirth : String?=null,
    val bio : String?=null,
    val weight : Double?=null,
    val height : Double?=null,
    val photoId : Int?=null,
    val photoUrl : String?=null,
    var results: List<AthleteResults> = listOf()
)
