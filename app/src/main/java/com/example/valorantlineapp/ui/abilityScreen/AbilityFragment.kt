package com.example.valorantlineapp.ui.abilityScreen

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.valorantlineapp.base.BaseFragment
import com.example.valorantlineapp.data.entity.Agent
import com.example.valorantlineapp.databinding.FragmentAbilityBinding


class AbilityFragment(private val agent: Agent) : BaseFragment<FragmentAbilityBinding>(FragmentAbilityBinding::inflate) {

    private val adapter by lazy { AbilityAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        agent.ability?.let { adapter.setData(it) }

    }
}