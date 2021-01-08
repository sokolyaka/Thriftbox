package thriftbox.mobile

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import thriftbox.mobile.di.dagger.DaggerApplicationComponent

class ThriftboxApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out ThriftboxApplication> =
        DaggerApplicationComponent.factory().create(this)
}
