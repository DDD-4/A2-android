package kr.ddd.a2.ext

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import kr.ddd.a2.base.BaseFragment

inline fun <reified O : LifecycleOwner, reified T> O.observe(
    data: LiveData<T>,
    noinline body: (T) -> Unit
) {
    data.observe(
        if (this is BaseFragment<*, *>) this.viewLifecycleOwner else this,
        Observer(body)
    )
}

inline fun <reified O : LifecycleOwner, reified T> O.observe(
    data: LiveData<T>,
    noinline body: () -> Unit
) {
    data.observe(
        if (this is BaseFragment<*, *>) this.viewLifecycleOwner else this,
        Observer { body.invoke() }
    )
}
