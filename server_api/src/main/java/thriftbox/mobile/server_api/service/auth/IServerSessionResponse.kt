package thriftbox.mobile.server_api.service.auth

interface IServerSessionResponse {
    val token: String
    val refreshToken: String
}
