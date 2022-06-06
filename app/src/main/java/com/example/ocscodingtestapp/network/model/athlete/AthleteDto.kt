package com.example.ocscodingtestapp.network.model.athlete

import com.google.gson.annotations.SerializedName

/**
 *  network model
 * Dto = Data transfer object
 */
data class AthleteDto(
    @SerializedName("athlete_id")
    val id : String?=null,

    @SerializedName("name")
    val name : String?=null,

    @SerializedName("surname")
    val surname : String?=null,

    @SerializedName("dateOfBirth")
    val dateOfBirth : String?=null,

    @SerializedName("bio")
    val bio : String?=null,

    @SerializedName("weight")
    val weight : Double?=null,

    @SerializedName("height")
    val height : Double?=null,

    @SerializedName("photo_id")
    val photoId : Int?=null

)