package com.infos.valorantlineapp.ui.detailScreen

import android.os.Bundle
import android.view.View
import com.infos.valorantlineapp.base.BaseFragment
import com.infos.valorantlineapp.data.entity.Agent
import com.infos.valorantlineapp.databinding.FragmentDetailBinding
import com.infos.valorantlineapp.utils.downloadFromUrl


class DetailFragment(private val agent: Agent) : BaseFragment<FragmentDetailBinding>(FragmentDetailBinding::inflate) {



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.descTV.text = agent.desc
        binding.portraitIV.downloadFromUrl(agent.portrait)

    }
}