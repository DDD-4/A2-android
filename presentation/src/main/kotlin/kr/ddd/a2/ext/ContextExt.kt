package kr.ddd.a2.ext

import android.content.Context
import android.content.res.Configuration
import android.widget.Toast

fun Context.toastS(message: CharSequence?) =
    Toast.makeText(this, message ?: "", Toast.LENGTH_SHORT).show()

fun Context.toastL(message: CharSequence?) =
    Toast.makeText(this, message ?: "", Toast.LENGTH_LONG).show()

fun Context.isRTL() =
    resources.configuration.layoutDirection == Configuration.SCREENLAYOUT_LAYOUTDIR_RTL
