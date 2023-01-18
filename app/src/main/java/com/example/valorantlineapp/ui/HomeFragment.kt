package com.example.valorantlineapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.valorantlineapp.base.BaseFragment
import com.example.valorantlineapp.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val adapter by lazy { HomeAdapter() }
    private val viewModel : HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(),2)

        viewModel.agent.observe(viewLifecycleOwner){
            it?.data.let { agent ->
                if (agent != null) {
                    adapter.setData(agent)
                }
            }
        }
    }

}