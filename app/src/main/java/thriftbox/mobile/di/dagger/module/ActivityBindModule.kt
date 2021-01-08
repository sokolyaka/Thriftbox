package thriftbox.mobile.di.dagger.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import thriftbox.mobile.di.dagger.scope.ActivityScope
import thriftbox.mobile.view.HostActivity

@Module
abstract class ActivityBindModule {

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            NavHostModule::class,
            ViewModelModule::class,
            HostActivityNavigationModule::class]
    )
    abstract fun hostActivityInjector(): HostActivity

}