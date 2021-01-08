package thriftbox.mobile.view.register.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import thriftbox.mobile.domain.auth.RegisterUserUseCase
import thriftbox.mobile.domain.auth.VerifyEmailUseCase
import thriftbox.mobile.domain.auth.VerifyPasswordUseCase
import thriftbox.mobile.route.IRouter
import thriftbox.mobile.server_api.service.exceptions.EmailBusyException
import thriftbox.mobile.utils.setValue
import javax.inject.Inject

class RegisterViewModel
@Inject constructor(
    private val verifyEmailUseCase: VerifyEmailUseCase,
    private val verifyPasswordUseCase: VerifyPasswordUseCase,
    private val registerUseCase: RegisterUserUseCase,
    private val router: IRouter
) : IRegisterViewModel, ViewModel() {

    override val isLoading: LiveData<Boolean> = MutableLiveData()
    override val isRegisterBtnEnable: LiveData<Boolean> = MutableLiveData()
    override val isEmailBusy: LiveData<Boolean> = MutableLiveData()
    override val isPasswordConfirmed: LiveData<Boolean> = MutableLiveData()

    private var name: String = ""
    private var email: String = ""
    private var password: String = ""
    private var confirmedPassword: String = ""

    override fun onNameEntered(txt: String) {
        name = txt
        checkAndSetRegisterBtnState()
    }

    override fun onEmailEntered(txt: String) {
        email = txt
        isEmailBusy.setValue(false)
        checkAndSetRegisterBtnState()
    }

    override fun onPasswordEntered(txt: String) {
        password = txt
        checkAndSetRegisterBtnState()
    }

    override fun onPasswordConfirmed(txt: String) {
        confirmedPassword = txt
        isPasswordConfirmed.setValue(true)
        checkAndSetRegisterBtnState()
    }

    override fun onRegisterPressed() {
        try {
            isLoading.setValue(true)
            if (!password.equals(confirmedPassword)) {
                isPasswordConfirmed.setValue(false)
                return
            }

            registerUseCase.register(email, password, name)
            router.resetToHomeScreen()
        } catch (e: EmailBusyException) {
            isEmailBusy.setValue(true)
        } finally {
            isLoading.setValue(false)
        }
    }

    override fun onLogin() {
        router.goToLoginScreen()
    }

    private fun checkAndSetRegisterBtnState() {
        isRegisterBtnEnable.setValue(
            !confirmedPassword.isEmpty()
                    && !name.isEmpty()
                    && verifyEmailUseCase.verify(email)
                    && verifyPasswordUseCase.verify(password)
        )
    }

}