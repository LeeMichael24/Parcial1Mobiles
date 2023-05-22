package com.example.parcial1mobiles.ui


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.parcial1mobiles.databinding.FragmentPcCreateNewBinding
import com.example.parcial1mobiles.viewModel.PcViewModel


class PcCreateNewFragment : Fragment() {

    private val pcViewModel: PcViewModel by activityViewModels {
        PcViewModel.Factory
    }

    private lateinit var binding: FragmentPcCreateNewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPcCreateNewBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        observerStatus()
    }

    private fun setViewModel() {
        binding.viewModel = pcViewModel
    }

    private fun observerStatus() {
        pcViewModel.status.observe(viewLifecycleOwner) { status ->
            when {
                status.equals(PcViewModel.WRONG_INFORMATION) -> {
                    Log.d("TESTAPP", status)
                    pcViewModel.clearStatus()
                }

                status.equals(PcViewModel.MOVIEW_CREATED) -> {
                    Log.d("TESTAPP", status)
                    Log.d("TESTAPP", pcViewModel.getPcs().toString())

                    pcViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }

    companion object {
        const val APP_TAG = "TESTAPP"
    }

}