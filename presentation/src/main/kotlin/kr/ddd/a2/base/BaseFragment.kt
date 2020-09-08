package kr.ddd.a2.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel

abstract class BaseFragment<T: ViewDataBinding, VM: ViewModel>(
    private val layoutResId: Int,
    private val bindingVariable: Int
) : Fragment() {
    lateinit var binding: T
    abstract val viewModel: VM

    open fun initView(binding: T) {}
    open fun subscribe(viewModel: VM) {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = setup(inflater, container)

    private fun setup(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = DataBindingUtil.inflate<T>(
        inflater,
        layoutResId,
        container,
        false
    ).apply {
        lifecycleOwner = viewLifecycleOwner
        setVariable(bindingVariable, viewModel)
    }.also {
        binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(binding)
        subscribe(viewModel)
    }
}
