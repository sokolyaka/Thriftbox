package thriftbox.mobile.view.register


import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sokolov.edittextutils.EmptyTextWatcher
import kotlinx.android.synthetic.main.fragment_register.*
import thriftbox.mobile.R
import thriftbox.mobile.view.register.view.RegisterView
import thriftbox.mobile.view.register.vm.RegisterViewModel
import javax.inject.Inject


class RegisterFragment
@Inject constructor(
    private val vmFactory: ViewModelProvider.Factory
) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.fragment_register, container, false)

    override fun onViewCreated(v: View, savedInstanceState: Bundle?) {
        val vm = ViewModelProvider(this, vmFactory).get(RegisterViewModel::class.java)
        val view = RegisterView(v)

        vm.isRegisterBtnEnable.observe(this, Observer { view.isRegisterEnable(it) })
        vm.isLoading.observe(this, Observer { view.isLoading(it) })
        vm.isEmailBusy.observe(this, Observer { view.isEmailBusy(it) })
        vm.isPasswordConfirmed.observe(this, Observer { view.isPasswordConfirmed(it) })

        et_register_screen_password.addTextChangedListener(
            object : EmptyTextWatcher() {
                override fun afterTextChanged(s: Editable?) {
                    vm.onPasswordEntered(s.toString())
                }
            })

        et_register_screen_confirm_password.addTextChangedListener(
            object : EmptyTextWatcher() {
                override fun afterTextChanged(s: Editable?) {
                    vm.onPasswordConfirmed(s.toString())
                }
            })
    }
}
