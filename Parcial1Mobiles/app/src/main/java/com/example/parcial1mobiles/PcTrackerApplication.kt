package com.example.parcial1mobiles

import android.app.Application
import com.example.parcial1mobiles.data.pcs
import com.example.parcial1mobiles.repository.PcRepository

class PcTrackerApplication: Application() {

    val pcRepository: PcRepository by lazy {
        PcRepository(pcs)
    }
}