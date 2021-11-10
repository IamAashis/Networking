package com.aashis.networking

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.aashis.networking.login.LoginPresenter
import com.aashis.networking.login.LoginView
import com.aashis.networking.model.LoginRequest
import com.aashis.networking.utils.NetworkUtils
import com.aashis.networking.utils.ProgressDialogHelper
import com.hannesdorfmann.mosby3.mvp.MvpActivity
import kotlinx.android.synthetic.main.activity_login2.*

class LoginActivity : MvpActivity<LoginView, LoginPresenter>(), LoginView {

    private var dialogHelper: ProgressDialogHelper? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        setUp()

    }

    private fun setUp() {
        dialogHelper = ProgressDialogHelper(this)
        loginBtn?.setOnClickListener {
            loginUser()
        }
    }

    private fun loginUser() {
        if (NetworkUtils.isNetworkAvailable(this)) {
            presenter.callLoginApi(
                LoginRequest(
                    emailLogin.text.toString(),
                    passwordLogin.text.toString()
                )
            )
        } else {
            Toast.makeText(this, getString(R.string.text_no_internet), Toast.LENGTH_SHORT).show()
        }
    }

    override fun navigateToVehicleActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun showErrorMessage(message: String?) {
        Toast.makeText(this@LoginActivity, message, Toast.LENGTH_SHORT).show()
    }

    override fun showValidationMessage(messageId: Int) {
        Toast.makeText(this@LoginActivity, getString(messageId), Toast.LENGTH_SHORT).show()
    }

    override fun showProgressBar() {
        dialogHelper?.show(getString(R.string.textLoading))
    }

    override fun hideProgressBar() {
        dialogHelper?.dismiss()
    }

    override fun createPresenter() = LoginPresenter()


}