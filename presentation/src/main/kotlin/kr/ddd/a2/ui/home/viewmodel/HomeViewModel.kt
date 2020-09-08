package kr.ddd.a2.ui.home.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import kr.ddd.a2.base.BaseViewModel
import kr.ddd.a2.ext.toLiveData
import kr.ddd.a2.utility.SingleLiveEvent

class HomeViewModel @ViewModelInject constructor() : BaseViewModel() {
    private val _toastEvent = SingleLiveEvent<String>()
    val toastEvent = _toastEvent.toLiveData()

    fun clickMessage() {
        _toastEvent.value = "Hello"
    }
}
