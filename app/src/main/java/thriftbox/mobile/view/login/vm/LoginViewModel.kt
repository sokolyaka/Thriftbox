package thriftbox.mobile.view.login.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import thriftbox.mobile.domain.auth.LoginUseCase
import thriftbox.mobile.domain.auth.VerifyEmailUseCase
import thriftbox.mobile.domain.auth.VerifyPasswordUseCase
import thriftbox.mobile.route.IRouter
import thriftbox.mobile.utils.setValue
import javax.inject.Inject

class LoginViewModel
@Inject constructor(
    private val verifyPasswordUseCase: VerifyPasswordUseCase,
    private val verifyEmailUseCase: VerifyEmailUseCase,
    private val router: IRouter,
    private val loginUseCase: LoginUseCase
) : ViewModel(), ILoginViewModel {

    override val isPasswordCorrect: LiveData<Boolean> = MutableLiveData()
    override val isEmailCorrect: LiveData<Boolean> = MutableLiveData()
    override val isLoginButtonEnable: LiveData<Boolean> = MutableLiveData()
    override val isLoading: LiveData<Boolean> = MutableLiveData()

    private var email: String = ""
    private var password: String = ""

    init {
        isLoginButtonEnable.setValue(false)
        isPasswordCorrect.setValue(false)
        isEmailCorrect.setValue(false)
        isLoading.setValue(false)
    }

    override fun onEmailEntered(email: String) {
        this.email = email
        updateLoginButtonState()
    }

    override fun onPasswordEntered(password: String) {
        this.password = password
        updateLoginButtonState()
    }

    override fun onLogin() {
        try {
            isLoading.setValue(true)
            isLoginButtonEnable.setValue(false)
            isEmailCorrect.setValue(verifyEmailUseCase.verify(email))
            isPasswordCorrect.setValue(verifyPasswordUseCase.verify(password))

            if (isEmailCorrect.value!! && isPasswordCorrect.value!!) {
                loginUseCase.login(email, password)
                router.resetToHomeScreen()
            }
        } finally {
            isLoading.setValue(false)
        }
    }

    private fun updateLoginButtonState() {
        isLoginButtonEnable.setValue(!email.isEmpty() && !password.isEmpty())
    }

    override fun onRegister() {
        router.goToRegisterScreen()
    }

}