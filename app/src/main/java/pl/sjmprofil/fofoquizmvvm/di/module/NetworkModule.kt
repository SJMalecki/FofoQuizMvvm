package pl.sjmprofil.fofoquizmvvm.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pl.sjmprofil.fofoquizmvvm.net.RestApi
import pl.sjmprofil.fofoquizmvvm.net.RestService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor()).build()
    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Singleton
    @Provides
    fun provideRestApi(okHttpClient: OkHttpClient, gson: Gson): RestApi {
        return Retrofit.Builder()
            .addCallAdapterFactory(CoroutineCallAdapterFactory.invoke())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("http://sjmprofil.pl")
            .client(okHttpClient)
            .build()
            .create(RestApi::class.java)
    }

    @Singleton
    @Provides
    fun provideRestService(restApi: RestApi) : RestService {
        return RestService(restApi)
    }

}