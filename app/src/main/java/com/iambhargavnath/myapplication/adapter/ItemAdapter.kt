package com.iambhargavnath.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.iambhargavnath.myapplication.model.Flower
import com.iambhargavnath.myapplication.R

class ItemAdapter (
    private val itemList: List<Flower>,
    private val onItemClick: (Flower) -> Unit
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameView = view.findViewById<TextView>(R.id.nameView)
        val descriptionView = view.findViewById<TextView>(R.id.descriptionView)
        val imageView = view.findViewById<ImageView>(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_flower, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]
        holder.nameView.text = item.name
        holder.descriptionView.text = item.description
        holder.imageView.setImageDrawable(item.image)
        holder.itemView.setOnClickListener { onItemClick(item) }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}