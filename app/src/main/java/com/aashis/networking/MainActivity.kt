package com.aashis.networking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.aashis.networking.Adapter.VehicleAdapter
import com.aashis.networking.model.Datum
import com.aashis.networking.network.RetrofitHelper
import com.aashis.networking.utils.NetworkUtils
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.aashis.networking.model.VehicleData

class MainActivity : AppCompatActivity() {


//    private lateinit var adapter: VehicleAdapter
    private lateinit var datumList: List<Datum>


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
                        datumList = response.body()?.data!!
//                        adapter.setData(datumList)

//                        adapter = VehicleAdapter(){}
//                        recycleview?.adapter = adapter
//                        recycleview?.layoutManager = LinearLayoutManager(this@MainActivity)


                        recycleview.layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.VERTICAL,false)

                        recycleview.adapter = VehicleAdapter(datumList)



                        Log.i("datumList", datumList.toString())


                        Toast.makeText(
                            applicationContext,
                            "this is toast message",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onFailure(call: Call<VehicleData>, t: Throwable) {
//                    hideProgressBar()
                }
            })

    }
}