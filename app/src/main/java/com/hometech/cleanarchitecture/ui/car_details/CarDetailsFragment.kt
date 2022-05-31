package com.hometech.cleanarchitecture.ui.car_details

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.hometech.cleanarchitecture.databinding.FragmentCarDetailBinding

class CarDetailsFragment : Fragment() {

    private lateinit var binding: FragmentCarDetailBinding
    private val args: CarDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCarDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.idTextview.text = args.id

    }

}