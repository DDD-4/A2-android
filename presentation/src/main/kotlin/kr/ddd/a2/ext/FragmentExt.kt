package kr.ddd.a2.ext

import androidx.fragment.app.Fragment

fun Fragment.showToast(msg: String) = requireContext().toastL(msg)
