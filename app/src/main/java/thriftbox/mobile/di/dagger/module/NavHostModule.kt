package thriftbox.mobile.di.dagger.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import thriftbox.mobile.di.dagger.fragment.InjectingNavHostFragment

@Module
abstract class NavHostModule {

    @ContributesAndroidInjector(
        modules = [
            FragmentBindingModule::class]
    )
    abstract fun navHostFragmentInjector(): InjectingNavHostFragment
}