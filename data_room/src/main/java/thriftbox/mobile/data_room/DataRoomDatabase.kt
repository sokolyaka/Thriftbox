package thriftbox.mobile.data_room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import thriftbox.mobile.data_room.DataRoomDatabase.Companion.VERSION
import thriftbox.mobile.data_room.auth.IServerSessionDao
import thriftbox.mobile.data_room.auth.RoomServerSession

@Database(entities = arrayOf(RoomServerSession::class), version = VERSION)
abstract class DataRoomDatabase : RoomDatabase() {
    companion object {
        const val VERSION = 1
        const val DB_NAME = "data_room_db"
        fun createDb(context: Context) =
            Room.databaseBuilder(context, DataRoomDatabase::class.java, DB_NAME).build()
    }

    abstract fun getServerSessionDao(): IServerSessionDao


}