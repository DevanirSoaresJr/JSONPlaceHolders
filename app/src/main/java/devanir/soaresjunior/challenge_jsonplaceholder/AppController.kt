package devanir.soaresjunior.challenge_jsonplaceholder

import android.app.Application
import devanir.soaresjunior.challenge_jsonplaceholder.di.application.ApplicationComponent
import devanir.soaresjunior.challenge_jsonplaceholder.di.application.ApplicationModule
import devanir.soaresjunior.challenge_jsonplaceholder.di.application.DaggerApplicationComponent

class AppController: Application() {
    val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }
}