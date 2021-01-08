package thriftbox.mobile.di.dagger.module

import android.content.Context
import dagger.Module
import dagger.Provides
import thriftbox.mobile.data.auth.ISessionRepository
import thriftbox.mobile.data_room.DataRoomDatabase
import thriftbox.mobile.data_room.auth.IServerSessionDao
import thriftbox.mobile.data_room.auth.RoomSessionRepository
import javax.inject.Singleton

@Module
class RoomDataModule {

    companion object {
        val sessionId = 777
    }

    @Singleton
    @Provides
    fun roomDb(context: Context): DataRoomDatabase {
        return DataRoomDatabase.createDb(context)
    }

    @Singleton
    @Provides
    fun sessionDao(db: DataRoomDatabase): IServerSessionDao {
        return db.getServerSessionDao()
    }

    @Singleton
    @Provides
    fun sessionRep(dao: IServerSessionDao): ISessionRepository {
        return RoomSessionRepository(dao, sessionId)
    }
}