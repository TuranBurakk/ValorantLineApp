package com.example.valorantlineapp.ui.lineUpScreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.valorantlineapp.databinding.MapRowBinding
import com.example.valorantlineapp.utils.downloadFromUrl

class MapAdapter(private val listener : SelectMap? = null) : RecyclerView.Adapter<MapAdapter.MapHolder>() {

    private var list = listOf<com.example.valorantlineapp.data.entity.Map>()

    class MapHolder(val binding : MapRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MapHolder {
        val view = LayoutInflater.from(parent.context)
        return MapHolder(MapRowBinding.inflate(view, parent, false))
    }

    override fun onBindViewHolder(holder: MapHolder, position: Int) {
        holder.binding.mapImageView.downloadFromUrl(
            list[position].icon
        )
        holder.binding.mapNameTV.text = list[position].name

        holder.binding.mapImageView.setOnClickListener {
            listener?.selectMap(list[position].name.toString(),position)
        }
    }

    override fun getItemCount() = list.size

    fun setData(newList : List<com.example.valorantlineapp.data.entity.Map>){
        if (newList != null){
            list = newList
        }
        notifyDataSetChanged()
    }


}