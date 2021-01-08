package thriftbox.mobile.server_api.service.auth

interface IAuthServerApi {

    fun login(req: ILoginRequest): IServerSessionResponse
    fun register(req: IRegisterRequest): IServerSessionResponse
    fun refreshToken(refreshToken: String): IServerSessionResponse

}