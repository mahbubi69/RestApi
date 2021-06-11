package com.example.restapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.restapi.databinding.ItemDataBinding

class DataAdapter(private val listData: ArrayList<PostRespon>) : RecyclerView.Adapter<DataAdapter.DataHolder>() {

    inner class DataHolder(private val binding: ItemDataBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(dataResponse : PostRespon){
            binding.tvArti.text = dataResponse.arti
            binding.tvAsma.text = dataResponse.asma
            binding.tvNama.text = dataResponse.nama
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataAdapter.DataHolder {
        val binding = ItemDataBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DataHolder(binding)
    }

    override fun onBindViewHolder(holder: DataHolder, position: Int) {
       holder.bind(listData[position])
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}