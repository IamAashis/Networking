package com.aashis.networking.login

import ApiResponse
import com.aashis.networking.model.LoginRequest
import com.ekbana.persistentstorage.feature.shared.model.response.auth.LoginResponseData

class LoginInteractor {

    fun callLogin(loginRequest: LoginRequest, apiResponse: ApiResponse<LoginResponseData?>) =
        LoginRepository.callLogin(loginRequest, apiResponse)
}