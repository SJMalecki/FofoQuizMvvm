package pl.sjmprofil.fofoquizmvvm.di.module

import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import pl.sjmprofil.fofoquizmvvm.di.ViewModelKey
import pl.sjmprofil.fofoquizmvvm.repository.MyRepository
import pl.sjmprofil.fofoquizmvvm.ui.MainViewModel

@Module
class ViewModelModule {

    @Provides
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun mainActivityViewModel(repository: MyRepository) : ViewModel = MainViewModel(repository)
}