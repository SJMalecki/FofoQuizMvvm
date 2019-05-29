package pl.sjmprofil.fofoquizmvvm.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import pl.sjmprofil.fofoquizmvvm.MyApplication
import pl.sjmprofil.fofoquizmvvm.di.module.AppModule
import pl.sjmprofil.fofoquizmvvm.di.module.NetworkModule
import pl.sjmprofil.fofoquizmvvm.di.module.RepositoryModule
import pl.sjmprofil.fofoquizmvvm.di.module.ViewModelModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityBuilder::class,
        AppModule::class,
        ViewModelModule::class,
        NetworkModule::class,
        RepositoryModule::class]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(myApplication: MyApplication)
}