package com.hometech.cleanarchitecture.fragment

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.hometech.cleanarchitecture.adapter.CarListAdapter
import com.hometech.cleanarchitecture.repository.MainRepository
import com.hometech.cleanarchitecture.cloud.APIServices
import com.hometech.cleanarchitecture.cloud.RetrofitHelper
import com.hometech.cleanarchitecture.databinding.FragmentCarListBinding
import com.hometech.cleanarchitecture.utils.ApiResponse
import com.hometech.cleanarchitecture.viewmodel.MainViewModel
import com.hometech.cleanarchitecture.viewmodel.MainViewModelFactory

class CarListFragment : Fragment() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var binding: FragmentCarListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCarListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val apiServices = RetrofitHelper.getInstance().create(APIServices::class.java)
        val mainRepository = MainRepository(apiServices)
        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(mainRepository))[MainViewModel::class.java]

        mainViewModel.carList.observe(viewLifecycleOwner) {
            when (it) {
                is ApiResponse.Error -> {
                    binding.progressBar.visibility = View.INVISIBLE
                    Toast.makeText(
                        context,
                        it.errorMessage,
                        Toast.LENGTH_SHORT
                    ).show()
                }
                is ApiResponse.Loading -> binding.progressBar.visibility = View.VISIBLE
                is ApiResponse.Success -> {
                    binding.progressBar.visibility = View.INVISIBLE
                    binding.apply {
                        it.data?.let { CarList ->
                            carListRecyclerView.adapter = CarListAdapter(context, CarList)
                            carListRecyclerView.layoutManager = LinearLayoutManager(context)
                            carListRecyclerView.setHasFixedSize(true)
                        }
                    }
                }
            }

        }
    }


}