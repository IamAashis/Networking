
import ApiResponse
import com.aashis.networking.constants.ApiConstants
import com.aashis.networking.model.LoginRequest
import com.aashis.networking.network.RetrofitHelper
import com.ekbana.persistentstorage.feature.shared.model.response.auth.LoginResponseData
import com.google.gson.GsonBuilder
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object LoginRepository {

    fun callLogin(loginRequest: LoginRequest, apiResponse: ApiResponse<LoginResponseData?>) {
        val json = GsonBuilder().create().toJson(loginRequest)
        val applicationJson = ApiConstants.contentTypeJson.toMediaTypeOrNull()
        val requestBody = json.toRequestBody(applicationJson)
        RetrofitHelper.getApiService().login(requestBody).enqueue(object :
            Callback<LoginResponseData> {
            override fun onResponse(
                call: Call<LoginResponseData>,
                response: Response<LoginResponseData>
            ) {
                apiResponse.onSuccess(response.body())
            }

            override fun onFailure(call: Call<LoginResponseData>, t: Throwable) {
                apiResponse.onFailure(t.message)
            }

        })

    }



}