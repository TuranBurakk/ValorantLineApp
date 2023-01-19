package com.example.valorantlineapp.ui.detailScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.valorantlineapp.R
import com.example.valorantlineapp.base.BaseFragment
import com.example.valorantlineapp.data.entity.Agent
import com.example.valorantlineapp.databinding.FragmentDetailBinding
import com.example.valorantlineapp.utils.downloadFromUrl


class DetailFragment(private val agent: Agent) : BaseFragment<FragmentDetailBinding>(FragmentDetailBinding::inflate) {



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.agentNmTV.text = agent.name
        binding.descTV.text = agent.desc
        binding.portraitIV.downloadFromUrl(agent.portrait)

    }
}