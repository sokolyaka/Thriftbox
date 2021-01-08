package thriftbox.mobile.view.register.view

import android.view.View
import androidx.core.view.isVisible
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterView(
    override val containerView: View
) : IRegisterView, LayoutContainer {

    override fun isLoading(isLoading: Boolean) {
        pb_register.isVisible = isLoading
    }

    override fun isRegisterEnable(isEnable: Boolean) {
        btn_register_screen_register.isEnabled = isEnable
    }

    override fun isEmailBusy(isBusy: Boolean) {
        et_register_screen_email.error = if (isBusy) "Email is busy" else null
    }

    override fun isPasswordConfirmed(isConfirmed: Boolean) {
        et_register_screen_confirm_password.error = if (isConfirmed) null else "Password not equals"
    }
}