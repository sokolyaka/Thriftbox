package thriftbox.mobile.view.login


import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sokolov.edittextutils.EmptyTextWatcher
import kotlinx.android.synthetic.main.fragment_login.*
import thriftbox.mobile.R
import thriftbox.mobile.view.login.view.LoginView
import thriftbox.mobile.view.login.vm.LoginViewModel
import javax.inject.Inject

class LoginFragment
@Inject
constructor(
    private var viewModelFactory: ViewModelProvider.Factory
) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(v: View, savedInstanceState: Bundle?) {

        val view = LoginView(v)
        val vm = ViewModelProvider(this, viewModelFactory).get(LoginViewModel::class.java)

        vm.isLoading.observe(viewLifecycleOwner, Observer { view.setProgressBarState(it) })
        vm.isLoginButtonEnable.observe(viewLifecycleOwner, Observer { view.setLoginButtonEnable(it) })
        vm.isEmailCorrect.observe(viewLifecycleOwner, Observer { view.setEmailValidationState(it) })
        vm.isPasswordCorrect.observe(viewLifecycleOwner, Observer { view.setPasswordValidationState(it) })

        btn_login.setOnClickListener { vm.onLogin() }
        btn_login_register.setOnClickListener { vm.onRegister() }
        et_login_email.addTextChangedListener(
            object : EmptyTextWatcher() {
                override fun afterTextChanged(s: Editable?) {
                    vm.onEmailEntered(s.toString())
                }
            })
        et_login_password.addTextChangedListener(
            object : EmptyTextWatcher() {
                override fun afterTextChanged(s: Editable?) {
                    vm.onPasswordEntered(s.toString())
                }
            })
    }
}
