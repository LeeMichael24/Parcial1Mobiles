package com.example.parcial1mobiles.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.parcial1mobiles.PcTrackerApplication
import com.example.parcial1mobiles.data.PcDataClass
import com.example.parcial1mobiles.repository.PcRepository

class PcViewModel(private val repository: PcRepository): ViewModel() {

    var brand = MutableLiveData("")
    var model = MutableLiveData("")
    var status = MutableLiveData("")

    fun getPcs() = repository.getPcs()

    private fun addPc(pcData: PcDataClass) = repository.addPc(pcData)


    fun createPc() {
        if(!validateData()){
            status.value = WRONG_INFORMATION
            return
        }
        val pcData = PcDataClass (
            brand.value!!,
            model.value!!
        )

        addPc(pcData)
        clearData()

        status.value = MOVIEW_CREATED
    }

    private fun validateData(): Boolean {
        when {
            brand.value.isNullOrEmpty() -> return false
            model.value.isNullOrEmpty() -> return false
        }
        return true
    }

    private fun clearData() {
        brand.value = ""
        model.value = ""
    }

    fun clearStatus() {
        status.value = INACTIVE
    }


    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as PcTrackerApplication
                PcViewModel(app.pcRepository)
            }
        }

        const val MOVIEW_CREATED = "Movie created"

        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }

    fun setSelectedMovie(pcData: PcDataClass){
        brand.value = pcData.brand
        model.value = pcData.models
    }
}