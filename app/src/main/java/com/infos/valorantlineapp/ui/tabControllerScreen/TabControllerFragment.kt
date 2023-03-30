package com.infos.valorantlineapp.ui.tabControllerScreen

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.core.view.doOnPreDraw
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.infos.valorantlineapp.base.BaseFragment
import com.infos.valorantlineapp.databinding.FragmentTabControllerBinding
import com.google.android.material.tabs.TabLayoutMediator
import com.infos.valorantlineapp.ui.youtubeScreen.VideoFragmentDirections


class TabControllerFragment : BaseFragment<FragmentTabControllerBinding>(FragmentTabControllerBinding::inflate) {

    private val adapter by lazy {
        TabControllerAdapter(childFragmentManager,lifecycle)
    }
    private val fragmentArray = arrayOf("Detaıl","Abılıty","Lıne Up")
    private val args : TabControllerFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Log.d("test", "page $position")
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }

            override fun onPageScrolled(position: Int,
                                        positionOffset: Float,
                                        positionOffsetPixels: Int) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }
        })
        initTabs()
        initBack()
        binding.agentNmTV.text = args.agent.name

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,
            object : OnBackPressedCallback(true){
                override fun handleOnBackPressed() {
                    if (isEnabled){
                   findNavController().navigate(TabControllerFragmentDirections.actionTabControllerFragmentToHomeFragment()) }
                }
            })

    }

    private fun initTabs(){
        args.agent.let { adapter.setArg(it) }
        binding.viewPager.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = fragmentArray[position]
        }.attach()
        binding.tabLayout.getTabAt(args.position)?.select()
        binding.viewPager.setCurrentItem(args.position,false)

    }

    private fun initBack(){
        binding.btnBack.setOnClickListener {
           findNavController().navigate(TabControllerFragmentDirections.actionTabControllerFragmentToHomeFragment())
        }
    }

}