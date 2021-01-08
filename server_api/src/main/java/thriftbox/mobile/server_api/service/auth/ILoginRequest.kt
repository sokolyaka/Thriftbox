package thriftbox.mobile.server_api.service.auth

interface ILoginRequest {
    val email: String
    val password: String
}
