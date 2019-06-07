package devanir.soaresjunior.challenge_jsonplaceholder.di.activity

import dagger.Subcomponent
import devanir.soaresjunior.challenge_jsonplaceholder.factories.ViewModelFactory
import devanir.soaresjunior.challenge_jsonplaceholder.ui.MainActivity

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    fun getViewModelFactory(): ViewModelFactory
    fun inject(mainActivity: MainActivity)
}