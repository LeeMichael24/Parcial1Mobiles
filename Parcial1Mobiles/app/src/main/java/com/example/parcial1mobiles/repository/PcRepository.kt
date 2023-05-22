package com.example.parcial1mobiles.repository

import com.example.parcial1mobiles.data.PcDataClass

class PcRepository(private val pcs: MutableList<PcDataClass>) {

    fun getPc() = pcs

    fun addPc(pc: PcDataClass) = pcs.add(pc)
}s