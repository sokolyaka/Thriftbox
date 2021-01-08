package thriftbox.mobile.domain.auth

import thriftbox.mobile.data.auth.ISessionRepository
import thriftbox.mobile.server_api.service.auth.IAuthServerApi

class RegisterUserUseCase(
    private val api: IAuthServerApi,
    private val sessionRep: ISessionRepository
) {

    fun register(email: String, password: String, name: String) {
        sessionRep.save(
            ServerSessionFromResponse(
                api.register(PojoRegisterRequest(email, password, name))
            )
        )
    }
}