package com.infos.valorantlineapp.ui.lineUpScreen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.infos.valorantlineapp.base.BaseFragment
import com.infos.valorantlineapp.data.entity.Agent
import com.infos.valorantlineapp.databinding.FragmentLineUpBinding
import com.infos.valorantlineapp.ui.tabControllerScreen.TabControllerFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LineUpFragment(private val agent: Agent) :
    BaseFragment<FragmentLineUpBinding>(FragmentLineUpBinding::inflate) , SelectMap {

    private val adapter by lazy { MapAdapter(this) }
    private val viewModel : LineUpViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mapRecycler.adapter =  adapter
        binding.mapRecycler.layoutManager = LinearLayoutManager(requireContext())

        viewModel.maps.observe(viewLifecycleOwner){
            it?.Map.let { Map ->
                if (Map != null) {
                    adapter.setData(Map)
                }
            }
        }

    }

    override fun selectMap(item: String, position: Int) {
            findNavController().
            navigate(TabControllerFragmentDirections.actionTabControllerFragmentToVideoFragment(agent,item))
    }

}