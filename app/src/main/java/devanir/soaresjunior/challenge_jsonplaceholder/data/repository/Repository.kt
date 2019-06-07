package devanir.soaresjunior.challenge_jsonplaceholder.data.repository

import androidx.lifecycle.LiveData
import devanir.soaresjunior.challenge_jsonplaceholder.data.entities.AlbumEntity
import devanir.soaresjunior.challenge_jsonplaceholder.data.model.AlbumResponse

interface Repository {
    fun getAlbums(): LiveData<List<AlbumResponse>>
    fun getAlbumsLocalASC():LiveData<List<AlbumEntity>>
    fun getAlbumsLocalDESC():LiveData<List<AlbumEntity>>
    fun insertAlbum(album: AlbumEntity)
}