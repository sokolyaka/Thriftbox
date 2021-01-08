package thriftbox.mobile.di.dagger.module

import dagger.Module
import dagger.Provides
import thriftbox.mobile.server_api.service.auth.IAuthServerApi
import thriftbox.mobile.server_api_mock.service.auth.MockAuthServiceApi
import javax.inject.Singleton

@Module
class ServerApiModule {

    @Singleton
    @Provides
    fun authServerApi(): IAuthServerApi {
        return MockAuthServiceApi()
    }

}