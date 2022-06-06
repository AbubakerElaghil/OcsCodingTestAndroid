package com.example.ocscodingtestapp.network.model.athleteResults

import com.google.gson.annotations.SerializedName

/**
 *  network model
 * Dto = Data transfer object
 */
data class AthleteResultsDto(

    @SerializedName("city")
    val city : String?=null,

    @SerializedName("year")
    val year : Int?=null,

    @SerializedName("gold")
    val gold : Int?=null,

    @SerializedName("silver")
    val silver : Int?=null,

    @SerializedName("bronze")
    val bronze : Int?=null
)