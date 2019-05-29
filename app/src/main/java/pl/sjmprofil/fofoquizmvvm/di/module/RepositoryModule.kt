package pl.sjmprofil.fofoquizmvvm.di.module

import dagger.Module
import dagger.Provides
import pl.sjmprofil.fofoquizmvvm.net.RestService
import pl.sjmprofil.fofoquizmvvm.repository.MyRepository
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(restService: RestService) : MyRepository {
        return MyRepository(restService)
    }
}