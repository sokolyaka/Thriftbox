package thriftbox.mobile.di.dagger.module

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import thriftbox.mobile.di.dagger.fragment.FragmentKey
import thriftbox.mobile.di.dagger.fragment.InjectingFragmentFactory
import thriftbox.mobile.view.login.LoginFragment
import thriftbox.mobile.view.register.RegisterFragment


@Module
abstract class FragmentBindingModule {

    @Binds
    @IntoMap
    @FragmentKey(LoginFragment::class)
    abstract fun bindLoginFragment(loginFragment: LoginFragment): Fragment

    @Binds
    @IntoMap
    @FragmentKey(RegisterFragment::class)
    abstract fun bindRegisterFragment(RegisterFragment: RegisterFragment): Fragment

    @Binds
    abstract fun bindFragmentFactory(factory: InjectingFragmentFactory): FragmentFactory
}