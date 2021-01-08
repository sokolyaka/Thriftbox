package thriftbox.mobile.view.register.vm

import androidx.lifecycle.LiveData

interface IRegisterViewModel {

    val isLoading: LiveData<Boolean>
    val isRegisterBtnEnable: LiveData<Boolean>
    val isEmailBusy: LiveData<Boolean>
    val isPasswordConfirmed: LiveData<Boolean>

    fun onNameEntered(txt: String)
    fun onEmailEntered(txt: String)
    fun onPasswordEntered(txt: String)
    fun onPasswordConfirmed(txt: String)

    fun onLogin()

    fun onRegisterPressed()
}