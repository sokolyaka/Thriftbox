package thriftbox.mobile.di.dagger.module

import androidx.navigation.findNavController
import dagger.Module
import dagger.Provides
import thriftbox.mobile.R
import thriftbox.mobile.route.IRouter
import thriftbox.mobile.route.NavigationComponentRouter
import thriftbox.mobile.view.HostActivity

@Module
class HostActivityNavigationModule {

    @Provides
    fun router(hostActivity: HostActivity): IRouter {
        return NavigationComponentRouter(hostActivity.findNavController(R.id.nav_host_fragment))
    }
}