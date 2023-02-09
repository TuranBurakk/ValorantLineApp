package com.example.valorantlineapp.ui.homeScreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.valorantlineapp.data.entity.Agent
import com.example.valorantlineapp.databinding.AgentRowBinding
import com.example.valorantlineapp.utils.downloadFromUrl

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.AgentHolder>() {
        private var list = mutableListOf<Agent>()
    class AgentHolder(val binding : AgentRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgentHolder {
        val view = LayoutInflater.from(parent.context)
        return AgentHolder(AgentRowBinding.inflate(view,parent,false))
    }

    override fun onBindViewHolder(holder: AgentHolder, position: Int) {
       if (list[position].uuid == "ded3520f-4264-bfed-162d-b080e2abccf9" ){
           val target = list[position]
            list.remove(target)
       }

        holder.binding.imageView.downloadFromUrl(
            list[position].icon
        )
        holder.binding.agentNameTV.text = list[position].name
        holder.binding.imageView.setOnClickListener {
            it.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToTabControllerFragment(list[position]))
        }
    }

    override fun getItemCount(): Int = list.size

    fun setData(newList: MutableList<Agent>){
        if (newList != null){
            list = newList
        }
        notifyDataSetChanged()
    }
}