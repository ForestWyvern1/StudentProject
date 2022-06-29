package com.nvah.studentproject.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nvah.studentproject.R
import com.nvah.studentproject.databinding.RecyclerViewItemViewBinding

class BasicRecyclerViewAdapter(private val context: Context) :
    RecyclerView.Adapter<BasicRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(context).inflate(R.layout.recycler_view_item_view, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding = RecyclerViewItemViewBinding.bind(holder.itemView)

        binding.rvTextView.text = "text $position"
    }

    override fun getItemCount(): Int = 10

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}