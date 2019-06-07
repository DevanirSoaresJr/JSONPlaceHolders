package devanir.soaresjunior.challenge_jsonplaceholder.di.application

import dagger.Component
import devanir.soaresjunior.challenge_jsonplaceholder.di.activity.ActivityComponent
import devanir.soaresjunior.challenge_jsonplaceholder.di.activity.ActivityModule

@ApplicationScope
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun newActivityComponent(activityModule: ActivityModule): ActivityComponent
}