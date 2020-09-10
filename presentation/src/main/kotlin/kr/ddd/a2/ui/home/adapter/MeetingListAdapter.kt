package kr.ddd.a2.ui.home.adapter

import kr.ddd.a2.BR
import kr.ddd.a2.R
import kr.ddd.a2.base.DataBindingListAdapter
import kr.ddd.a2.ext.DIFF_DEFAULT
import kr.ddd.a2.ui.home.model.MeetingListUiModel

class MeetingListAdapter(
    listener: (MeetingListUiModel) -> Unit
) : DataBindingListAdapter<MeetingListUiModel>(
    diffCallback = DIFF_DEFAULT(),
    layoutResId = R.layout.holder_meeting_list,
    bindingVariable = BR.item,
    itemClickListener = listener
)
