package com.example.practice_apps.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.practice_apps.Users
import com.example.practice_apps.util.APIService
import com.example.practice_apps.util.Status
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import kotlin.random.Random.Default.nextInt


class HomeRepository @Inject constructor(

) {
    private val compositeDisposable = CompositeDisposable()
    private val userliveData = MutableLiveData<Status<List<Users>>>(
        Status(
            Status.StatusType.INIT, arrayListOf(), ""
        )
    )

    private val userLoading = MutableLiveData<Boolean>(false)
    private val imgUrlList= arrayListOf<String>(
        "https://i.imgur.com/AxETlhd.jpg",
        "https://i.imgur.com/VPTNmPW.jpeg",
        "https://i.imgur.com/BMYo3el.jpeg",
        "https://i.imgur.com/7YHo3CS.jpeg",
        "https://i.imgur.com/c1Bmd0M.jpeg",
        "https://i.imgur.com/ZTia70g.png",
        "https://i.imgur.com/RbkSaII.jpeg",
        "https://i.imgur.com/lMwuCUG.jpeg",
        "https://i.imgur.com/duHNLwP.jpeg",
    )
    // private val api: APIService
    fun getUserStatusLiveData(): MutableLiveData<Status<List<Users>>> {
        return userliveData
    }

    fun getUserLiveData(): MutableLiveData<Status<List<Users>>> {
        return userliveData
    }

    fun  randomImgUrl(): String {
        val random = Random()

        return imgUrlList[random.nextInt(8)]

    }
    fun getLoading(): MutableLiveData<Boolean> {
        return userLoading
    }

    fun getUserList() {
        Log.e("aaaa", "getUserList: ")
        userLoading.postValue(true)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .connectTimeout(20, TimeUnit.SECONDS)
                    .readTimeout(20, TimeUnit.SECONDS)
                    .writeTimeout(20, TimeUnit.SECONDS)
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        val api = retrofit.create(APIService::class.java)
        compositeDisposable.add(
            api
                .users
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<List<Users>>() {
                    override fun onNext(t: List<Users>) {
                        Log.e("aaaa", "onNext: ${t.size}")
                        userLoading.value = false
                        for (u in t){
                            u.imgUrl=randomImgUrl()
                        }
                        if (t.isNullOrEmpty()) {
                            userliveData.postValue(Status.error("Error", null))
                        } else {
                            Log.e("aaaa", "userliveData.postValue: ${t.size}")
                            userliveData.postValue(Status.success(t))
                        }
                    }

                    override fun onError(e: Throwable) {
                        Log.e("aaaa", "onError: $e")
                        userLoading.value = false
                        userliveData.postValue(Status.error("Error : ${e.message}", null))
                    }

                    override fun onComplete() {
                        Log.e("aaaa", "onComplete: ")
                    }
                })
        )

    }

    fun addFavoriteUser(user: Users) {

    }

    fun disposeComposite() {
        compositeDisposable.dispose()
    }
}