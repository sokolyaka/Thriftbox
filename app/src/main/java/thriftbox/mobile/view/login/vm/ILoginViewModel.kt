package thriftbox.mobile.view.login.vm

import androidx.lifecycle.LiveData

interface ILoginViewModel {
    val isPasswordCorrect: LiveData<Boolean>
    val isEmailCorrect: LiveData<Boolean>
    val isLoginButtonEnable: LiveData<Boolean>
    val isLoading: LiveData<Boolean>

    fun onEmailEntered(email: String)
    fun onPasswordEntered(password: String)
    fun onLogin()
    fun onRegister()
}