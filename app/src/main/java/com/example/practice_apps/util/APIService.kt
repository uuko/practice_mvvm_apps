package com.example.practice_apps.util

import com.example.practice_apps.Users
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.http.GET


interface APIService {
    @get:GET("/users")
    val users: Observable<List<Users>>

    companion object {
        private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        // Function : for configure retrofit and return ApiHelper
        fun create(): APIService {
            val okHttp = OkHttpClient.Builder()

                .addInterceptor(logger)
                .build()
//              .addInterceptor(BasicInterceptor(ACCESS_TOKEN))
// .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .client(okHttp)
            return Retrofit.Builder()

                .build()
                .create(APIService::class.java)
        }
    }
}