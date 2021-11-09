package com.aashis.networking.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aashis.networking.R
import com.aashis.networking.model.Datum
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.custom_vehicle_list.view.*

//private val onItemClicked: (position: Int) -> Unit?
class VehicleAdapter(private var vehiclesList: List<Datum> = ArrayList()) :
    RecyclerView.Adapter<VehicleAdapter.MyViewHolder>() {

//    private var vehicleList = emptyList<Datum>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.custom_vehicle_list, parent, false)
        )

    }

    override fun getItemCount(): Int {
        return vehiclesList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = vehiclesList[position]
        holder.itemView.modelTv.text = currentItem.model
        holder.itemView.colorTV.text = currentItem.color
        holder.itemView.salesPersonTv.text = currentItem.salesPerson
        holder.itemView.dateTV.text = currentItem.purchaseDate
        Picasso.get().load(currentItem.vehicleImage).into(holder.itemView.vehicleImage)


//
//
//        holder.itemView.rowLayout.setOnClickListener {
//            onItemClicked(position)
//        }
    }

    fun setData(vehicleList: List<Datum>) {
        this.vehiclesList = vehicleList
        notifyDataSetChanged()
    }

}





