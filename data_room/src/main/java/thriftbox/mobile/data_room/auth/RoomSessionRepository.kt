package thriftbox.mobile.data_room.auth

import thriftbox.mobile.data.auth.IServerSession
import thriftbox.mobile.data.auth.ISessionRepository

class RoomSessionRepository(
    private val dao: IServerSessionDao,
    private val id: Int
) : ISessionRepository {

    override fun save(session: IServerSession) {
        dao.save(RoomServerSession(id, session))
    }

    override fun load(): IServerSession {
        return dao.getById(id)
    }
}