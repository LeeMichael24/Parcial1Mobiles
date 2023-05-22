package com.example.parcial1mobiles.ui.billboardPc

import androidx.recyclerview.widget.RecyclerView
import com.example.parcial1mobiles.data.PcDataClass
import com.example.parcial1mobiles.data.pcs

class PcRecyclerViewHolder(private val binding: PcItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(pc: PcDataClass, clickListener: (PcDataClass) -> Unit ) {
        binding.textView5.text = pc.brand
        binding.textView6.text = pc.model

        binding.movieItemCardView.setOnClickListener {
            clickListener(pc)
        }
    }
}