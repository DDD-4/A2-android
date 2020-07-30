package kr.ddd.a2.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import kr.ddd.domain.Entity

/**
 * Created by Lee Oh Hyoung on 2020/07/09.
 */
abstract class BaseViewHolder<M: Entity>(
    private val binding: ViewBinding
) : RecyclerView.ViewHolder(binding.root) {

    abstract fun onBind(item: M)

}
