package devanir.soaresjunior.challenge_jsonplaceholder.di.application

import android.app.Application
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import devanir.soaresjunior.challenge_jsonplaceholder.common.DATABASE_NAME
import devanir.soaresjunior.challenge_jsonplaceholder.data.database.AlbumDatabase
import devanir.soaresjunior.challenge_jsonplaceholder.data.network.AlbumService
import devanir.soaresjunior.challenge_jsonplaceholder.data.repository.RepositoryImpl
import devanir.soaresjunior.challenge_jsonplaceholder.network.NetworkModule

@Module(includes = [NetworkModule::class])
class ApplicationModule(private val application: Application) {

    @Provides
    @ApplicationScope
    fun providesContext(): Context = application

    @Provides
    @ApplicationScope
    fun providesDatabase(): AlbumDatabase = Room.databaseBuilder(application.applicationContext,
        AlbumDatabase::class.java, DATABASE_NAME).build()

    @Provides
    @ApplicationScope
    fun providesRepository(albumService: AlbumService, database: AlbumDatabase): RepositoryImpl =
        RepositoryImpl(albumService, database)
}