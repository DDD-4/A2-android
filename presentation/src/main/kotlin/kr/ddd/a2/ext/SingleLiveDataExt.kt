package kr.ddd.a2.ext

import androidx.lifecycle.LiveData
import kr.ddd.a2.utility.SingleLiveEvent

inline fun <reified T> SingleLiveEvent<T>.toLiveData() = this as LiveData<T>
