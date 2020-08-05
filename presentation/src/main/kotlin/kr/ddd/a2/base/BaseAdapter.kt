package kr.ddd.a2.base

import androidx.recyclerview.widget.RecyclerView
import kr.ddd.domain.Entity


abstract class BaseAdapter<M: Entity> : RecyclerView.Adapter<BaseViewHolder<M>>() {

    open fun init() { /* explicitly empty */ }

    open fun update() { /* explicitly empty */ }

}
