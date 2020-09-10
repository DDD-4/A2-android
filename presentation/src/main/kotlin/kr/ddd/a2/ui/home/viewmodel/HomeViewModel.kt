package kr.ddd.a2.ui.home.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import kr.ddd.a2.base.BaseViewModel
import kr.ddd.a2.ext.toLiveData
import kr.ddd.a2.ui.home.model.MeetingListUiModel
import kr.ddd.a2.utility.SingleLiveEvent
import java.util.concurrent.TimeUnit.SECONDS
import kotlin.random.Random

class HomeViewModel @ViewModelInject constructor() : BaseViewModel() {
    private val random
        get() = Random(System.currentTimeMillis())
    private val start
        get() = random.nextInt(0, 20)

    private val _toastEvent = SingleLiveEvent<String>()
    val toastEvent = _toastEvent.toLiveData()

    private val _isRefreshing = MutableLiveData<Boolean>()
    val isRefreshing = _isRefreshing.toLiveData()

    private val _meetingList = MutableLiveData<List<MeetingListUiModel>>(listOf())
    val meetingList = _meetingList.toLiveData()
    val meetingSize = _meetingList.map { it.size }

    fun refresh() {
        Observable.range(start, start)
            .map {
                MeetingListUiModel(
                    String(Character.toChars(0x1F60A + (it % 10))),
                    title = "$it"
                )
            }
            .toList()
            .toObservable()
            .delay(3, SECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { _isRefreshing.value = true }
            .doOnComplete { _isRefreshing.value = false }
            .subscribe { _meetingList.value = it }
            .addDisposable()
    }

    init {
        refresh()
    }
}
