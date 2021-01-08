package thriftbox.mobile.domain.auth

import thriftbox.mobile.data.auth.ISessionRepository
import thriftbox.mobile.server_api.service.auth.IAuthServerApi

class LoginUseCase(
    private val api: IAuthServerApi,
    private val sessionRep: ISessionRepository
) {

    fun login(email: String, password: String) {
        sessionRep.save(
            ServerSessionFromResponse(
                api.login(PojoLoginRequest(email, password))
            )
        )
    }
}