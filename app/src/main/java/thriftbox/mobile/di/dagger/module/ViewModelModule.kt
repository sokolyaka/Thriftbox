package thriftbox.mobile.di.dagger.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import thriftbox.mobile.di.dagger.vm.ViewModelFactory
import thriftbox.mobile.di.dagger.vm.ViewModelKey
import thriftbox.mobile.view.login.vm.LoginViewModel

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    internal abstract fun postLoginViewModel(viewModel: LoginViewModel): ViewModel
}