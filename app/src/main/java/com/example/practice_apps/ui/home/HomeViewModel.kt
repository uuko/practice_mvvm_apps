package com.example.practice_apps.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.practice_apps.Users
import com.example.practice_apps.util.NotNullMutableLiveData
import com.example.practice_apps.util.Status
import javax.inject.Inject

class HomeViewModel @Inject
constructor(private val repository: HomeRepository) : ViewModel() {

    val userItems: MutableLiveData<List<Users>>
        get() = _userItems
    val loading: MutableLiveData<Boolean>
        get() = _loading
    val imgUrl: MutableLiveData<String>
        get() = _imgUrl
    private var _userItems: MutableLiveData<List<Users>> = MutableLiveData<List<Users>>(arrayListOf())
    private var _imgUrl: MutableLiveData<String> = MutableLiveData<String>("")
    private var _loading:MutableLiveData<Boolean> = MutableLiveData<Boolean>(false)
    var text:MutableLiveData<String> = MutableLiveData("9999")
    fun testText(){
        text.value="Click7777"
    }
    fun getUsers() {

        repository.getUserList()
        _userItems.postValue(repository.getUserLiveData().value?.data)
        _loading.postValue(repository.getLoading().value)


    }


    override fun onCleared() {

        repository.disposeComposite()
        super.onCleared()
    }


}