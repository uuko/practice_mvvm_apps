package com.example.practice_apps.db

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class UserDBMgr {
//    fun insertSharesItem(
//        mContext: Context?,
//        listener: LoadDBListener.InsertListener,
//        entity: List<MainTable?>?
//    ) {
//        val database: MainDBDataBase = MainDBDataBase.getInstance(mContext)
//        Log.d("dbbbbbbbbbbbbbbb", "insertSharesItem: ")
//        mDisposable.add(database.mainDbDao().insertAllPrivateData(entity)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(object : Action() {
//                @Throws(Exception::class)
//                fun run() {
//                    listener.onComplete("ok")
//                }
//            }, object : Consumer<Throwable?>() {
//                @Throws(Exception::class)
//                fun accept(throwable: Throwable) {
//                    Log.d("dbbbbbbbbbbbbbbb", "insertSharesItem: $throwable")
//                    listener.onError("Error$throwable")
//                }
//            })
//        )
//    }
}