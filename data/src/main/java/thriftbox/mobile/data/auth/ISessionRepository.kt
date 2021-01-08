package thriftbox.mobile.data.auth

interface ISessionRepository {
    fun save(session: IServerSession)
    fun load(): IServerSession
}