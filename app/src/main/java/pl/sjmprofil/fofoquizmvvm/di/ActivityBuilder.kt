package pl.sjmprofil.fofoquizmvvm.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.sjmprofil.fofoquizmvvm.ui.MainActivity

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindMainActivity() : MainActivity
}