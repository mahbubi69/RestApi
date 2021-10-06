package com.example.restapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.restapi.databinding.ItemDataBinding

class DataAdapter(
    private val listData: ArrayList<PostRespon>,
    val itemClikHandler: ItemClikHandler
) :
    RecyclerView.Adapter<DataAdapter.DataHolder>() {

    inner class DataHolder(val binding: ItemDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(dataResponse: PostRespon) {
            binding.tvArti.text = dataResponse.arti
            binding.tvAsma.text = dataResponse.asma
            binding.tvNama.text = dataResponse.nama


            binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    when (p2) {
                        0 -> {

                        }
                        1 -> {
                            itemClikHandler.onSpinnerClik(dataResponse, "baca")
                        }

                        2 -> {
                            itemClikHandler.onSpinnerClik(dataResponse, "hafalkan")
                        }
                        3 -> {
                            itemClikHandler.onSpinnerClik(dataResponse, "simpan")
                        }
                        else -> {

                        }
                    }
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataAdapter.DataHolder {
        val binding = ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataHolder(binding)
    }

    override fun onBindViewHolder(holder: DataHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}