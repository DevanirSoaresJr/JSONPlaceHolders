package devanir.soaresjunior.challenge_jsonplaceholder.di.activity

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import devanir.soaresjunior.challenge_jsonplaceholder.factories.ViewModelFactory
import devanir.soaresjunior.challenge_jsonplaceholder.ui.MainViewModel

@Module
class ActivityModule(val activity: AppCompatActivity) {

    @Provides
    @ActivityScope
    fun providesMainViewModel(viewModelFactory: ViewModelFactory) = ViewModelProviders.of(activity, viewModelFactory)
        .get(MainViewModel::class.java)
}