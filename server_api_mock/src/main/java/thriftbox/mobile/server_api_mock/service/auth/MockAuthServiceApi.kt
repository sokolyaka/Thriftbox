package thriftbox.mobile.server_api_mock.service.auth

import thriftbox.mobile.server_api.service.auth.IAuthServerApi
import thriftbox.mobile.server_api.service.auth.ILoginRequest
import thriftbox.mobile.server_api.service.auth.IRegisterRequest
import thriftbox.mobile.server_api.service.auth.IServerSessionResponse

class MockAuthServiceApi : IAuthServerApi {

    override fun login(req: ILoginRequest): IServerSessionResponse {
        return MockServerSessionResponse()
    }

    override fun register(req: IRegisterRequest): IServerSessionResponse {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun refreshToken(refreshToken: String): IServerSessionResponse {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}