package kr.ddd.a2.ui.home

import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kr.ddd.a2.BR
import kr.ddd.a2.R
import kr.ddd.a2.base.BaseFragment
import kr.ddd.a2.databinding.FragmentHomeBinding
import kr.ddd.a2.ext.observe
import kr.ddd.a2.ext.showToast
import kr.ddd.a2.ext.toPx
import kr.ddd.a2.ui.common.PaddingDividerDecoration
import kr.ddd.a2.ui.home.adapter.MeetingListAdapter
import kr.ddd.a2.ui.home.viewmodel.HomeViewModel

@AndroidEntryPoint
class Home : BaseFragment<FragmentHomeBinding, HomeViewModel>(
    layoutResId = R.layout.fragment_home,
    bindingVariable = BR.vm
) {
    override val viewModel: HomeViewModel by viewModels()
    private val meetingListAdapter by lazy {
        MeetingListAdapter() {
            showToast(it.title)
        }
    }

    override fun initView(binding: FragmentHomeBinding) = with(binding) {
        rvMeetingList.run {
            addItemDecoration(PaddingDividerDecoration(paddingBottom = 16.toPx()))
            adapter = meetingListAdapter
        }
    }

    override fun subscribe(viewModel: HomeViewModel) = with(viewModel) {
        observe(toastEvent, ::showToast)
        observe(meetingList, meetingListAdapter::submitList)
    }
}
