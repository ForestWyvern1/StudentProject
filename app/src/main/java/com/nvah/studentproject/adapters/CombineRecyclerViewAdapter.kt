package com.nvah.studentproject.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nvah.studentproject.R
import com.nvah.studentproject.databinding.RecyclerViewItemViewBinding
import com.nvah.studentproject.databinding.SecondRecyclerViewItemBinding
import com.nvah.studentproject.models.SomeModel

class CombineRecyclerViewAdapter(private val context: Context, val list: ArrayList<SomeModel>) :
    RecyclerView.Adapter<CombineRecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind1(position: Int) {

            val binding = RecyclerViewItemViewBinding.bind(itemView)
            binding.rvTextView.text = "text $position"

        }

        fun bind2(position: Int) {

            val binding = SecondRecyclerViewItemBinding.bind(itemView)
            binding.secondRecyclerTextView.text = "second text $position"

        }

        fun bind(position: Int) {
            if (list[position].type == 0) {
                bind1(position)
            } else {
                bind2(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if (viewType == 0) {
            ViewHolder(
                LayoutInflater.from(context)
                    .inflate(R.layout.recycler_view_item_view, parent, false)
            )
        } else {
            ViewHolder(
                LayoutInflater.from(context)
                    .inflate(R.layout.second_recycler_view_item, parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = list.size

    override fun getItemViewType(position: Int): Int {
        return list[position].type
    }

}