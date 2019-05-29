package pl.sjmprofil.fofoquizmvvm

import android.app.Activity
import android.app.Application
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import pl.sjmprofil.fofoquizmvvm.di.DaggerAppComponent
import javax.inject.Inject

class MyApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector : DispatchingAndroidInjector<Activity>

    override fun activityInjector() : DispatchingAndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }

    override fun onCreate() {
        super.onCreate()

        setupDagger2()
    }

    private fun setupDagger2() {
        DaggerAppComponent.builder().application(this).build().inject(this)
    }
}
