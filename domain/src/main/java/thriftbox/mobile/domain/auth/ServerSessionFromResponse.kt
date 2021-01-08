package thriftbox.mobile.domain.auth

import thriftbox.mobile.data.auth.IServerSession
import thriftbox.mobile.server_api.service.auth.IServerSessionResponse

class ServerSessionFromResponse(
    private val response: IServerSessionResponse
) : IServerSession {
    override val token: String
        get() = response.token
    override val refreshToken: String
        get() = response.refreshToken

}
