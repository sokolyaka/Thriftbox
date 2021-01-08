package thriftbox.mobile.server_api_mock.service.auth

import thriftbox.mobile.server_api.service.auth.IServerSessionResponse

class MockServerSessionResponse : IServerSessionResponse {
    override val token: String
        get() = "mockToken"
    override val refreshToken: String
        get() = "mockRefreshToken"
}
