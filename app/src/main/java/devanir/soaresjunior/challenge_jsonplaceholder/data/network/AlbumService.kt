package devanir.soaresjunior.challenge_jsonplaceholder.data.network

import devanir.soaresjunior.challenge_jsonplaceholder.data.model.AlbumResponse
import io.reactivex.Single
import retrofit2.http.GET

interface AlbumService {
    @GET("albums")
    fun getAlbums(): Single<List<AlbumResponse>>
}