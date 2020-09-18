package kr.ddd.a2.ext

import android.content.res.Resources

private val density
    get() = Resources.getSystem().displayMetrics.density

fun Int.toDp() = (this / density).toInt()

fun Int.toPx() = (this * density).toInt()
