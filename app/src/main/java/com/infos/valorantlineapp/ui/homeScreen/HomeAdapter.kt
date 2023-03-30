package com.infos.valorantlineapp.ui.homeScreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.infos.valorantlineapp.data.entity.Agent
import com.infos.valorantlineapp.databinding.AgentRowBinding
import com.infos.valorantlineapp.utils.downloadFromUrl

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.AgentHolder>() {
    private var list = listOf<Agent>()

    class AgentHolder(val binding : AgentRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgentHolder {
        val view = LayoutInflater.from(parent.context)
        return AgentHolder(AgentRowBinding.inflate(view,parent,false))
    }

    override fun onBindViewHolder(holder: AgentHolder, position: Int) {

        holder.binding.imageView.downloadFromUrl(list[position].icon)

        holder.binding.agentNameTV.text = list[position].name

        holder.binding.imageView.setOnClickListener {
            it.findNavController().navigate(HomeFragmentDirections
                .actionHomeFragmentToTabControllerFragment(list[position],0))
        }
    }

    override fun getItemCount(): Int = list.size

    fun setData(newList: List<Agent>){
        if (newList != null){
            list = newList
        }
        notifyDataSetChanged()
    }

}