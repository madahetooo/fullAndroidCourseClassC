package com.apps.fullandroidcourseclassc.firebasestorageapp.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apps.fullandroidcourseclassc.databinding.ItemClothesBinding
import com.bumptech.glide.Glide

class ClothesImagesAdapter(var urls :List<String>)  : RecyclerView.Adapter<ClothesImagesAdapter.ClothesImagesViewHolder>(){
    inner class ClothesImagesViewHolder(val binding: ItemClothesBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClothesImagesViewHolder {
        return ClothesImagesViewHolder(
            ItemClothesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: ClothesImagesViewHolder, position: Int) {
        val url = urls[position]
        Glide.with(holder.itemView).load(url).into(holder.binding.ivClothesImageItem)
    }

    override fun getItemCount(): Int {
        return urls.size
    }

}