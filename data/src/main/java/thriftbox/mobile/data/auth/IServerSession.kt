package thriftbox.mobile.data.auth

interface IServerSession {
    val token: String
    val refreshToken: String
}
