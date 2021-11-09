package com.aashis.networking.network


import com.aashis.networking.constants.ApiConstants
import com.aashis.networking.model.VehicleData
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET(ApiConstants.endPoint)
    fun getVehicleData(): Call<VehicleData>



}