package thriftbox.mobile.view.login.view

import android.view.View
import androidx.core.content.ContextCompat
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.fragment_login.*
import thriftbox.mobile.utils.setVisibility

class LoginView(override val containerView: View) : ILoginView, LayoutContainer {
    override fun setProgressBarState(isVisible: Boolean) {
        pb_login.setVisibility(isVisible)
    }

    override fun setLoginButtonEnable(isEnable: Boolean) {
        btn_login.isEnabled = isEnable
    }

    override fun setEmailValidationState(isValid: Boolean) {
        et_login_email.setTextColor(
            ContextCompat.getColor(
                containerView.context,
                if (isValid) android.R.color.black else android.R.color.holo_red_dark
            )
        )
    }

    override fun setPasswordValidationState(isValid: Boolean) {
        et_login_password.setTextColor(
            ContextCompat.getColor(
                containerView.context,
                if (isValid) android.R.color.black else android.R.color.holo_red_dark
            )
        )
    }
}