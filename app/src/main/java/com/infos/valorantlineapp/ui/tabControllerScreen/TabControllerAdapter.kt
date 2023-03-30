package com.infos.valorantlineapp.ui.tabControllerScreen

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.infos.valorantlineapp.data.entity.Agent
import com.infos.valorantlineapp.ui.abilityScreen.AbilityFragment
import com.infos.valorantlineapp.ui.lineUpScreen.LineUpFragment
import com.infos.valorantlineapp.ui.detailScreen.DetailFragment

class TabControllerAdapter (fragmentManager: FragmentManager, lifecycle: Lifecycle
): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount() = 3

    private lateinit var currentArgId : Agent


    override fun createFragment(position: Int): Fragment {
        return  when(position){
            0 -> DetailFragment(currentArgId)
            1 -> AbilityFragment(currentArgId)
            2-> LineUpFragment(currentArgId)
            else -> Fragment()
        }
    }
    fun setArg(agent: Agent){
        currentArgId = agent
    }
}