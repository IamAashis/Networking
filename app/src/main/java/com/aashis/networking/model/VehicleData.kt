package com.aashis.networking.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class VehicleData (
    @SerializedName("data")
    @Expose
    var data: List<Datum>? = null
)