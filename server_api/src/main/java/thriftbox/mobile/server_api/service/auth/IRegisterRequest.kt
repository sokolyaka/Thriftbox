package thriftbox.mobile.server_api.service.auth

interface IRegisterRequest {
    val email: String
    val password: String
    val name: String
}
