package thriftbox.mobile.di.dagger

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import thriftbox.mobile.ThriftboxApplication
import thriftbox.mobile.di.dagger.module.AppModule
import thriftbox.mobile.di.dagger.module.DomainModule
import thriftbox.mobile.di.dagger.module.RoomDataModule
import thriftbox.mobile.di.dagger.module.ServerApiModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        DomainModule::class,
        RoomDataModule::class,
        ServerApiModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<ThriftboxApplication> {

    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<ThriftboxApplication>

}