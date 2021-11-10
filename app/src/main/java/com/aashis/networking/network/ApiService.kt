package com.aashis.networking.network


import com.aashis.networking.constants.ApiConstants
import com.aashis.networking.model.VehicleData
import com.ekbana.persistentstorage.feature.shared.model.response.auth.LoginResponseData
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET(ApiConstants.endPoint)
    fun getVehicleData(): Call<VehicleData>

    @POST(ApiConstants.loginUrl)
    fun login(
        @Body requestBody: RequestBody
    ): Call<LoginResponseData>

}