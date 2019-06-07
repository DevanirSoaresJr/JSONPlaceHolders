package devanir.soaresjunior.challenge_jsonplaceholder.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import devanir.soaresjunior.challenge_jsonplaceholder.data.database.AlbumDatabase
import devanir.soaresjunior.challenge_jsonplaceholder.data.entities.AlbumEntity
import devanir.soaresjunior.challenge_jsonplaceholder.data.model.AlbumResponse
import devanir.soaresjunior.challenge_jsonplaceholder.data.network.AlbumService
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class RepositoryImpl(private val albumService: AlbumService, private val database: AlbumDatabase): Repository {
    override fun getAlbums(): MutableLiveData<List<AlbumResponse>> {
        albumService.getAlbums()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<List<AlbumResponse>>{
                override fun onSuccess(t: List<AlbumResponse>) {
                    albums.value = t
                    state.value = State.SUCCESS
                }

                override fun onSubscribe(d: Disposable) {
                    state.value = State.LOADING
                }

                override fun onError(e: Throwable) {
                    state.value = State.FAILURE
                    e.printStackTrace()
                }
            })
        return albums
    }


    private val albums = MutableLiveData<List<AlbumResponse>>()
    private val state = MutableLiveData<State>()


    override fun getAlbumsLocalASC(): LiveData<List<AlbumEntity>> = database.albumDao().getAlbumsASC()
    override fun getAlbumsLocalDESC(): LiveData<List<AlbumEntity>> = database.albumDao().getAlbumsDESC()

    override fun insertAlbum(album: AlbumEntity) {
        Thread{
            database.albumDao().insert(album)
        }.start()
    }

    fun getState():LiveData<State> = state

    enum class State{
        SUCCESS,
        LOADING,
        FAILURE
    }
}
