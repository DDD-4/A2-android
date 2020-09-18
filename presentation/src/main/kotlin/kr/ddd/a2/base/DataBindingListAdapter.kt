package kr.ddd.a2.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

abstract class DataBindingListAdapter<T : DisplayModel>(
    diffCallback: DiffUtil.ItemCallback<T>,
    private val layoutResId: Int,
    private val bindingVariable: Int,
    private val itemClickListener: ((T) -> Unit)? = null
) : ListAdapter<T, DataBindingViewHolder<T>>(diffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = DataBindingViewHolder<T>(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            layoutResId,
            parent,
            false
        ),
        bindingVariable,
    ) { position ->
        itemClickListener?.invoke(getItem(position))
    }

    override fun onBindViewHolder(
        holder: DataBindingViewHolder<T>,
        position: Int
    ) = holder.bindItem(getItem(position))
}