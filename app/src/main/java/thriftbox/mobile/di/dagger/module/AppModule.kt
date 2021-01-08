package thriftbox.mobile.di.dagger.module

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import thriftbox.mobile.ThriftboxApplication
import thriftbox.mobile.di.dagger.activity.host.HostActivityModule

@Module(includes = [HostActivityModule::class])
abstract class AppModule {

    @Binds
    abstract fun bindApplication(app: ThriftboxApplication): Application

    @Binds
    abstract fun bindApplicationContext(app: ThriftboxApplication): Context

}