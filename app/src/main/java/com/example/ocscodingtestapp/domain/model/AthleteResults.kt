package com.example.ocscodingtestapp.domain.model

/**
 *  domain model (UI model ) that will be used for views
 *   this class is for results for the Athlete
 */
data class AthleteResults(
    val city : String?=null,
    val year : Int?=null,
    val gold : Int?=null,
    val silver : Int?=null,
    val bronze : Int?=null
)
