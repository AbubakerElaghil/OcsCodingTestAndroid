package com.example.ocscodingtestapp.network.model.game

import com.google.gson.annotations.SerializedName

/**
 *  network model
 * Dto = Data transfer object
 */
data class GameDto(
    @SerializedName("game_id")
    val id : Int?=null,

    @SerializedName("city")
    val city : String?=null,

    @SerializedName("year")
    val year : Int?=null

)