package com.aashis.networking.login

import ApiResponse
import com.aashis.networking.R
import com.aashis.networking.model.LoginRequest
import com.ekbana.persistentstorage.feature.shared.model.response.auth.LoginResponseData
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter


class LoginPresenter : MvpBasePresenter<LoginView>() {
    private var loginInteractor: LoginInteractor? = null

    override fun attachView(view: LoginView) {
        super.attachView(view)
        loginInteractor = LoginInteractor()
    }

    override fun detachView() {
        super.detachView()
        loginInteractor = null
    }

    fun callLoginApi(loginRequest: LoginRequest) {
        ifViewAttached { view ->
            if (!validateFields(loginRequest, view)) {
                return@ifViewAttached
            }
            view.showProgressBar()
            loginInteractor?.callLogin(loginRequest, object : ApiResponse<LoginResponseData?> {
                override fun onSuccess(response: LoginResponseData?) {
                    view.hideProgressBar()
                    view.navigateToVehicleActivity()
                }

                override fun onFailure(message: String?) {
                    view.hideProgressBar()
                    view.showErrorMessage(message)
                }

            })

        }

    }


    fun login(){

    }

    private fun validateFields(loginRequest: LoginRequest, view: LoginView): Boolean {
        if (loginRequest.email.isNullOrEmpty()) {
            view.showValidationMessage(R.string.textUserEmpty)
            return false
        } else if (loginRequest.password.isNullOrEmpty()) {
            view.showValidationMessage(R.string.textPasswordEmpty)
            return false
        }
        return true
    }
}