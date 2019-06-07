package devanir.soaresjunior.challenge_jsonplaceholder.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import devanir.soaresjunior.challenge_jsonplaceholder.data.repository.RepositoryImpl
import devanir.soaresjunior.challenge_jsonplaceholder.ui.MainViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(val repositoryImpl: RepositoryImpl): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) MainViewModel(repositoryImpl) as T
        else throw IllegalArgumentException("ViewModel not found")
    }
}