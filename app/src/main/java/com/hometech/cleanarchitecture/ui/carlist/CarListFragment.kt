package com.hometech.cleanarchitecture.ui.carlist

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.hometech.cleanarchitecture.MyApplication
import com.hometech.cleanarchitecture.data.api.APIServices
import com.hometech.cleanarchitecture.databinding.FragmentCarListBinding
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main
import javax.inject.Inject

class CarListFragment : Fragment() {

    private lateinit var binding: FragmentCarListBinding

    @Inject
    lateinit var apiServices: APIServices
    private lateinit var carListJob: Job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (requireActivity().application as MyApplication).appComponent.inject(this)
    }

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

        carListJob = viewLifecycleOwner.lifecycleScope.launch(Main) {

            val result = apiServices.getCarList()
            if (result.body() != null) {
                binding.apply {
                    progressBar.visibility = View.INVISIBLE
                    carListRecyclerView.adapter = CarListAdapter(requireContext(), result.body()!!)
                    carListRecyclerView.layoutManager = LinearLayoutManager(context)
                    carListRecyclerView.setHasFixedSize(true)
                }
            } else {
                binding.progressBar.visibility = View.INVISIBLE
                Toast.makeText(context, result.message(), Toast.LENGTH_SHORT).show()
            }

        }

    }

    override fun onDestroy() {
        super.onDestroy()
        carListJob.cancel()
    }


}

