package com.example.ocscodingtestapp.domain.model

/**
 *  domain model (UI model ) that will be used for views
 *  this class is for Game
 */
data class Game(
    val id: Int? = null,
    val city: String? = null,
    val year: Int? = 0,
    var athletesList : List<Athlete> = listOf()
)
