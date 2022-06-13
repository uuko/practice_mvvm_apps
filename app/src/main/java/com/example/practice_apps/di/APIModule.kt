package com.example.practice_apps.di

import androidx.annotation.Nullable
import com.example.practice_apps.util.APIService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class APIModule {

    @Provides
    @Singleton
    @Named("UserRetrofit")
    fun provideUserApi(   @Named("UserApi") retrofit: Retrofit): APIService {
        return retrofit.create(APIService::class.java)
    }

    @Provides
    @Singleton
    @Named("UserApi")
    fun provideUserRetrofit(
        @Named("UserApiUrl") url: String,
        @Named("UserApiClient") okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        //addCallAdapterFactory 是要支援有Observerable的
    }

    @Singleton
    @Provides
    @Named("UserApiUrl")
    fun provideUserApiUrl(): String {
        return "https://jsonplaceholder.typicode.com"

        //如果要getResource要context.get ...
    }

    @Singleton
    @Provides
    @Named("UserApiClient")
    fun provideUserOkhttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return httpLoggingInterceptor.let {
            OkHttpClient.Builder()
                .addInterceptor(it)
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .build()
        }
    }

    //HttpLoggingInterceptor 有404 200 等連線狀態用的
    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }
}