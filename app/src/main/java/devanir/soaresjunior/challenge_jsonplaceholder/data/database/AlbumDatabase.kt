package devanir.soaresjunior.challenge_jsonplaceholder.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import devanir.soaresjunior.challenge_jsonplaceholder.common.DATABASE_VERSION
import devanir.soaresjunior.challenge_jsonplaceholder.data.dao.AlbumDao
import devanir.soaresjunior.challenge_jsonplaceholder.data.entities.AlbumEntity

@Database(entities = [AlbumEntity::class], version = DATABASE_VERSION, exportSchema = false)
abstract class AlbumDatabase: RoomDatabase() {

    abstract fun albumDao(): AlbumDao
}