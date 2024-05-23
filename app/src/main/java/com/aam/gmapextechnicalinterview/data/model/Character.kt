package com.aam.gmapextechnicalinterview.data.model
import com.google.gson.annotations.SerializedName


data class Character(

    @SerializedName("info") var info: Info? = Info(),
    @SerializedName("results") var results: ArrayList<Results> = arrayListOf()

)