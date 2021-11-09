package com.aashis.networking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.aashis.networking.model.Datum
import com.aashis.networking.network.RetrofitHelper
import com.aashis.networking.utils.NetworkUtils
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.aashis.networking.model.VehicleData

class MainActivity : AppCompatActivity() {

    private lateinit var datumList: ArrayList<Datum>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUp()

    }

    private fun setUp() {
        if (NetworkUtils.isNetworkAvailable(this)) {
            getVechicleInfo()
        } else {
            Toast.makeText(this, getString(R.string.text_no_internet), Toast.LENGTH_SHORT).show()
        }
    }

    private fun getVechicleInfo() {

        RetrofitHelper.getApiService()
            .getVehicleData()
            .enqueue(object :
                Callback<VehicleData> {
                override fun onResponse(call: Call<VehicleData>, response: Response<VehicleData>) {
//                    hideProgressBar()
                    if (response.isSuccessful && response.code() == 200) {
//                        val vehicleResponse = response.body()
//                        datumList = response.body()?.data!!


//                        val stringBuilder = "Country: " +
//                                vehicleResponse?.data?. +
//                                "\n" +
//                                "Temperature: " +
//                                vehicleResponse?.main?.temp +
//                                "\n" +
//                                "Temperature(Min): " +
//                                vehicleResponse?.main?.tempMin +
//                                "\n" +
//                                "Temperature(Max): " +
//                                vehicleResponse?.main?.tempMax +
//                                "\n" +
//                                "Humidity: " +
//                                vehicleResponse?.main?.humidity +
//                                "\n" +
//                                "Pressure: " +
//                                vehicleResponse?.main?.pressure

//                        txvVehicleData?.text = stringBuilder

                        Toast.makeText(applicationContext,"this is toast message",Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<VehicleData>, t: Throwable) {
//                    hideProgressBar()
                    txvVehicleData?.text = t.message
                }
            })

    }
}