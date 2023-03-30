package com.infos.valorantlineapp.ui.homeScreen

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.infos.valorantlineapp.base.BaseFragment
import com.infos.valorantlineapp.databinding.FragmentHomeBinding
import com.infos.valorantlineapp.ui.tabControllerScreen.TabControllerFragmentDirections
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val adapter by lazy { HomeAdapter() }
    private val viewModel: HomeViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        viewModel.agent.observe(viewLifecycleOwner) {
            it?.data.let { agent ->
                if (agent != null) {
                    adapter.setData(agent)
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,
            object : OnBackPressedCallback(true){
                override fun handleOnBackPressed() {
                    if (isEnabled){
                        val builder = AlertDialog.Builder(requireContext())
                        builder.setTitle("")
                        builder.setMessage("Do you want to quit?")
                        builder.setPositiveButton("Yes",object : DialogInterface.OnClickListener{
                            override fun onClick(dialog: DialogInterface?, which: Int) {
                                activity?.finish()
                            }


                        })
                        builder.setNegativeButton("No",null).show()
                    }
                }
            })


    }



}