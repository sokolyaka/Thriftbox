package thriftbox.mobile.data_room.auth

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface IServerSessionDao {

    @Insert(onConflict = REPLACE)
    fun save(session: RoomServerSession)

    @Query("SELECT * FROM server_session WHERE id == :id")
    fun getById(id: Int): RoomServerSession

}
