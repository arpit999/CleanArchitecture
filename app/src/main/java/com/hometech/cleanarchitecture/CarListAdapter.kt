package com.hometech.cleanarchitecture

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.hometech.cleanarchitecture.databinding.ListItemBinding
import com.hometech.cleanarchitecture.pojo.CarList
import com.squareup.picasso.Picasso
import retrofit2.Response

class CarListAdapter(
    private val context: Context,
    private val list: CarList,
) :
    RecyclerView.Adapter<CarListAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ItemViewHolder(
        ListItemBinding.inflate(LayoutInflater.from(context), parent, false).root
    )

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        ListItemBinding.bind(holder.itemView).apply {
            val carObject = list.listings[position]

            val imageUrl = carObject.images.firstPhoto.large
            val car = "${carObject.year} ${carObject.make} ${carObject.model} ${carObject.trim}"
            val price_mileage = "\$ ${carObject.currentPrice} | ${carObject.mileage} mi"
            val location = "${carObject.dealer.city}, ${carObject.dealer.state}"

            Picasso.get().load(imageUrl).placeholder(R.drawable.placeholder).into(carImageView)
            carNameTextview.text = car
            priceMilageTextView.text = price_mileage
            locationTextView.text = location

            cardView.setOnClickListener { view ->
                val bundle = bundleOf("id" to carObject.id)
                view.findNavController()
                    .navigate(R.id.action_carListFragment_to_carDetailsFragment, bundle)
            }

            callDealerTextView.setOnClickListener {
                Toast.makeText(context, "Call Dealer Clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount(): Int {
        return list.listings.size
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view)
}




