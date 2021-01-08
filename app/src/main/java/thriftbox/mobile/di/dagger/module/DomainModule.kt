package thriftbox.mobile.di.dagger.module

import android.util.Patterns
import dagger.Module
import dagger.Provides
import thriftbox.mobile.data.auth.ISessionRepository
import thriftbox.mobile.domain.auth.LoginUseCase
import thriftbox.mobile.domain.auth.VerifyEmailUseCase
import thriftbox.mobile.domain.auth.VerifyPasswordUseCase
import thriftbox.mobile.server_api.service.auth.IAuthServerApi
import javax.inject.Singleton

@Module
class DomainModule {

    @Singleton
    @Provides
    fun verifyPasswordUseCase(): VerifyPasswordUseCase {
        return VerifyPasswordUseCase()
    }

    @Singleton
    @Provides
    fun verifyEmailUseCase(): VerifyEmailUseCase {
        return VerifyEmailUseCase(Patterns.EMAIL_ADDRESS)
    }

    @Singleton
    @Provides
    fun loginUseCase(api: IAuthServerApi, sessionRep: ISessionRepository): LoginUseCase {
        return LoginUseCase(api, sessionRep)
    }

}