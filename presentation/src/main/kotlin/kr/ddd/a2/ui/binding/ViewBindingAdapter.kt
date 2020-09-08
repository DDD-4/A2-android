package kr.ddd.a2.ui.binding

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("click")
fun View.bindClickListener(func: () -> Unit) {
    setOnClickListener { func.invoke() }
}
