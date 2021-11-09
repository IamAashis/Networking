package com.aashis.networking.network

import com.aashis.networking.constants.ApiConstants
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitHelper {

    private var apiService: ApiService? = null
    private val gsonConverter = GsonConverterFactory.create(GsonBuilder().setLenient().create())

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(gsonConverter)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl(ApiConstants.BASE_URL)
        .client(getOkHttpClient())
        .build()

    private fun getOkHttpClient(): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
        return okHttpClient.build()
    }


    fun getApiService(): ApiService {
        if (apiService == null) {
            apiService = retrofit.create(ApiService::class.java)
        }
        return apiService ?: retrofit.create(ApiService::class.java)
    }

}