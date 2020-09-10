package kr.ddd.a2.ext

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kr.ddd.a2.utility.SingleLiveEvent

inline fun <reified T> MutableLiveData<T>.toLiveData() = this as LiveData<T>

inline fun <reified T> SingleLiveEvent<T>.toLiveData() = this as LiveData<T>
