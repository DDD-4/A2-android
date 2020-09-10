package kr.ddd.a2.ui.common

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import androidx.recyclerview.widget.RecyclerView.State
import kr.ddd.a2.ext.isRTL

class PaddingDividerDecoration @JvmOverloads constructor(
    private val paddingLeft: Int? = null,
    private val paddingTop: Int? = null,
    private val paddingRight: Int? = null,
    private val paddingBottom: Int? = null
) : ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: State
    ) = with(outRect) {
        super.getItemOffsets(outRect, view, parent, state)

        val isRTL = parent.context.isRTL()
        val paddingStart = if (isRTL) paddingRight ?: right else paddingLeft ?: left
        val paddingEnd = if (isRTL) paddingLeft ?: left else paddingRight ?: right

        outRect.set(
            paddingStart,
            paddingTop ?: top,
            paddingEnd,
            paddingBottom ?: bottom
        )
    }
}