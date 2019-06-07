package devanir.soaresjunior.challenge_jsonplaceholder.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import devanir.soaresjunior.challenge_jsonplaceholder.data.entities.AlbumEntity
import devanir.soaresjunior.challenge_jsonplaceholder.data.model.AlbumResponse
import devanir.soaresjunior.challenge_jsonplaceholder.data.repository.RepositoryImpl

class MainViewModel(private val repository: RepositoryImpl): ViewModel() {


    fun getAlbumsNetwork():LiveData<List<AlbumResponse>> = repository.getAlbums()
    fun getAlbumsASC():LiveData<List<AlbumEntity>> = repository.getAlbumsLocalASC()
    fun getAlbumsDESC():LiveData<List<AlbumEntity>> = repository.getAlbumsLocalDESC()
    fun insertAlbum(userId: Int, id: Int, title: String){
        repository.insertAlbum(AlbumEntity(userId, id, title))
    }
    fun getState() = repository.getState()
}