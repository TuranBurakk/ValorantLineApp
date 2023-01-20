package com.example.valorantlineapp.ui.abilityScreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.valorantlineapp.data.entity.Ability
import com.example.valorantlineapp.databinding.AbilityRowBinding
import com.example.valorantlineapp.utils.downloadFromUrl

class AbilityAdapter : RecyclerView.Adapter<AbilityAdapter.AbilityHolder>(){
            private var list = listOf<Ability?>()
    class AbilityHolder(val binding : AbilityRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbilityHolder {
        val view = LayoutInflater.from(parent.context)
        return AbilityHolder(AbilityRowBinding.inflate(view,parent,false))
    }

    override fun onBindViewHolder(holder: AbilityHolder, position: Int) {
        holder.binding.apply {
            abilityNameTV.text = list[position]?.abilityName.toString()
            abilityDescTV.text = list[position]?.abilityDesc.toString()
            abilityImageView.downloadFromUrl(
                list[position]?.abilityIcon
            )
        }
    }

    override fun getItemCount() = list.size

    fun setData(newList : List<Ability>){
        if (newList != null){
            list = newList
        }
        notifyDataSetChanged()
    }
}