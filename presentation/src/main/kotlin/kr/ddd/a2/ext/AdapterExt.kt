package kr.ddd.a2.ext

import androidx.recyclerview.widget.DiffUtil
import kr.ddd.a2.base.DisplayModel

inline fun <reified T : DisplayModel> DIFF_DEFAULT() = object : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(
        oldItem: T,
        newItem: T
    ) = oldItem == newItem

    override fun areContentsTheSame(
        oldItem: T,
        newItem: T
    ) = oldItem == newItem
}
