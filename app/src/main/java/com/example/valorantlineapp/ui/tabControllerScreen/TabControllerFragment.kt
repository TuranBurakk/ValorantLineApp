package com.example.valorantlineapp.ui.tabControllerScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.valorantlineapp.R
import com.example.valorantlineapp.base.BaseFragment
import com.example.valorantlineapp.databinding.FragmentTabControllerBinding
import com.google.android.material.tabs.TabLayoutMediator


class TabControllerFragment : BaseFragment<FragmentTabControllerBinding>(FragmentTabControllerBinding::inflate) {

    private val adapter by lazy {
        TabControllerAdapter(childFragmentManager,lifecycle)
    }
    private val fragmentArray = arrayOf("Detail","Ability","Line Up")
    private val args : TabControllerFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTabs()
        initBack()
    }

    private fun initTabs(){
        args.agent.let { adapter.setArg(it) }
        binding.viewPager.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = fragmentArray[position]
        }.attach()
    }

    private fun initBack(){
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}