package kr.ddd.a2.ui.home

import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kr.ddd.a2.BR
import kr.ddd.a2.R
import kr.ddd.a2.base.BaseFragment
import kr.ddd.a2.databinding.FragmentHomeBinding
import kr.ddd.a2.ext.observe
import kr.ddd.a2.ext.showToast
import kr.ddd.a2.ui.home.viewmodel.HomeViewModel

@AndroidEntryPoint
class Home : BaseFragment<FragmentHomeBinding, HomeViewModel>(
    layoutResId = R.layout.fragment_home,
    bindingVariable = BR.vm
) {
    override val viewModel: HomeViewModel by viewModels()

    override fun initView(binding: FragmentHomeBinding) = with(binding) {
        tvMessage.text = getString(R.string.app_name)
    }

    override fun subscribe(viewModel: HomeViewModel) = with(viewModel) {
        observe(toastEvent, ::showToast)
    }
}
