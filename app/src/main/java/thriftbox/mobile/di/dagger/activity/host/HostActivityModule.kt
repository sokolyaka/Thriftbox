package thriftbox.mobile.di.dagger.activity.host

import dagger.Module
import dagger.android.ContributesAndroidInjector
import thriftbox.mobile.di.dagger.module.HostActivityNavigationModule
import thriftbox.mobile.di.dagger.module.NavHostModule
import thriftbox.mobile.di.dagger.module.ViewModelModule
import thriftbox.mobile.di.dagger.scope.ActivityScope
import thriftbox.mobile.view.HostActivity


@Module
abstract class HostActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            NavHostModule::class,
            ViewModelModule::class,
            HostActivityNavigationModule::class]
    )
    abstract fun hostActivity(): HostActivity
}