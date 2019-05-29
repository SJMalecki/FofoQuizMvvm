package pl.sjmprofil.fofoquizmvvm.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import pl.sjmprofil.fofoquizmvvm.vm.MyViewModelFactory
import javax.inject.Provider
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideViewModelFactory(providers : Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>) :
            ViewModelProvider.Factory = MyViewModelFactory(providers)
}