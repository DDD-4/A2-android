package kr.ddd.a2.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class DataBindingViewHolder<T>(
    private val binding: ViewDataBinding,
    private val bindingVariable: Int,
    private val itemClickPositionListener: (Int) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.root.setOnClickListener { itemClickPositionListener(adapterPosition) }
    }

    fun bindItem(item: T) = with(binding) {
        setVariable(bindingVariable, item)
        executePendingBindings()
    }
}
