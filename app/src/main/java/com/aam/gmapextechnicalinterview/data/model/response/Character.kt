package com.aam.gmapextechnicalinterview.data.model.response

import com.aam.gmapextechnicalinterview.data.model.response.Info
import com.aam.gmapextechnicalinterview.data.model.response.Results
import com.google.gson.annotations.SerializedName


data class Character(

    @SerializedName("info") var info: Info?,
    @SerializedName("results") var results: ArrayList<Results> = arrayListOf()

)