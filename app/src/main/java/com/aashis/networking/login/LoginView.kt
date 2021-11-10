package com.aashis.networking.login

import com.hannesdorfmann.mosby3.mvp.MvpView

interface LoginView:MvpView {
    fun showProgressBar()
    fun hideProgressBar()
    fun navigateToVehicleActivity()
    fun showErrorMessage(message:String?)
    fun showValidationMessage(messageId:Int)
}