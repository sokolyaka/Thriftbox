package thriftbox.mobile.view.register.view

interface IRegisterView {

    fun isLoading(isLoading: Boolean)
    fun isRegisterEnable(isEnable: Boolean)
    fun isEmailBusy(isBusy: Boolean)
    fun isPasswordConfirmed(isConfirmed: Boolean)
}