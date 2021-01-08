package thriftbox.mobile.view.login.view

interface ILoginView {

    fun setProgressBarState(isVisible: Boolean)
    fun setLoginButtonEnable(isEnable: Boolean)
    fun setEmailValidationState(isValid: Boolean)
    fun setPasswordValidationState(isValid: Boolean)
}