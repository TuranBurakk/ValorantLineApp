package com.example.valorantlineapp.ui.detailScreen

import android.os.Bundle
import android.view.View
import com.example.valorantlineapp.base.BaseFragment
import com.example.valorantlineapp.data.entity.Agent
import com.example.valorantlineapp.databinding.FragmentDetailBinding
import com.example.valorantlineapp.utils.downloadFromUrl


class DetailFragment(private val agent: Agent) : BaseFragment<FragmentDetailBinding>(FragmentDetailBinding::inflate) {



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.descTV.text = agent.desc
        binding.portraitIV.downloadFromUrl(agent.portrait)

    }
}