package com.aashis.networking.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class Datum (
    @SerializedName("reference_number")
    @Expose
    var referenceNumber: String? = null,

    @SerializedName("chassis_number")
    @Expose
    var chassisNumber: String? = null,

    @SerializedName("purchase_date")
    @Expose
    var purchaseDate: String? = null,

    @SerializedName("model")
    @Expose
    var model: String? = null,

    @SerializedName("color")
    @Expose
    var color: String? = null,

    @SerializedName("sales_person")
    @Expose
    var salesPerson: String? = null,

    @SerializedName("purchase_destination")
    @Expose
    var purchaseDestination: String? = null,

    @SerializedName("vehicle_image")
    @Expose
    var vehicleImage: String? = null,

    @SerializedName("photo_count")
    @Expose
    var photoCount: Int? = null
)