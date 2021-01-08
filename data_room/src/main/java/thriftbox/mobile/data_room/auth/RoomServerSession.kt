package thriftbox.mobile.data_room.auth

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import thriftbox.mobile.data.auth.IServerSession

@Entity(tableName = "server_session")
class RoomServerSession(
    @PrimaryKey val id: Int,
    override val token: String,
    @ColumnInfo(name = "refresh_token") override val refreshToken: String
) : IServerSession {
    constructor(id: Int, origin: IServerSession) : this(id, origin.token, origin.refreshToken)
}
