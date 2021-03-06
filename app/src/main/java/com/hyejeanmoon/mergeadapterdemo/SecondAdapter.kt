package com.hyejeanmoon.mergeadapterdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hyejeanmoon.mergeadapterdemo.databinding.ItemSecondBinding

class SecondAdapter :
    ListAdapter<String, SecondAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from((parent.context))
        val binding: ItemSecondBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_second, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.textView2.text = getItem(position)
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_second
    }

    class DiffCallback : DiffUtil.ItemCallback<String>() {
        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem === newItem
        }
    }


    class ViewHolder(var binding: ItemSecondBinding) : RecyclerView.ViewHolder(binding.root)
}