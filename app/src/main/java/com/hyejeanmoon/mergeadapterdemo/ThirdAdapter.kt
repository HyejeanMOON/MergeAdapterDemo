package com.hyejeanmoon.mergeadapterdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hyejeanmoon.mergeadapterdemo.databinding.ItemThirdBinding

class ThirdAdapter(private val data: List<String>) :
    ListAdapter<String, ThirdAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from((parent.context))
        val binding: ItemThirdBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_third, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.textView1.text = data[position]
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class DiffCallback : DiffUtil.ItemCallback<String>() {
        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem === newItem
        }
    }


    class ViewHolder(var binding: ItemThirdBinding) : RecyclerView.ViewHolder(binding.root)
}