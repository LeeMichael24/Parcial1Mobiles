package com.example.parcial1mobiles.ui.billboardPc

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial1mobiles.data.PcDataClass

class RecyclerViewAdapter(private val clickListener: (PcDataClass) -> Unit)
     : RecyclerView.Adapter<PcRecyclerViewHolder>() {


    private val pcs = ArrayList<PcDataClass>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PcRecyclerViewHolder {
        TODO()
    }

    override fun onBindViewHolder(holder: PcRecyclerViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}