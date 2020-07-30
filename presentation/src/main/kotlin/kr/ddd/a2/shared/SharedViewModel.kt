/*
 * Created by Lee Oh Hyoung on 2020/07/31 .. 
 */
package kr.ddd.a2.shared

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import kr.ddd.a2.base.BaseViewModel

class SharedViewModel @ViewModelInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle
) : BaseViewModel()
