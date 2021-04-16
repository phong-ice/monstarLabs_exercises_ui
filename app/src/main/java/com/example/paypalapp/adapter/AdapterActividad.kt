package com.example.paypalapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.paypalapp.R
import com.example.paypalapp.databinding.ItemListActividadInFragmentRecibirBinding
import com.example.paypalapp.model.Actividad

class AdapterActividad(val context: Context, val actividads: ArrayList<Actividad>) :
    RecyclerView.Adapter<AdapterActividad.ViewHolder>() {

    private lateinit var _binding: ItemListActividadInFragmentRecibirBinding

    class ViewHolder(view: ItemListActividadInFragmentRecibirBinding) :
        RecyclerView.ViewHolder(view.root) {

        var tv_title = view.tvTitleItem
        var tv_des = view.tvDescriptionItem
        var tv_monney = view.tvMonneyItem
        var view_bottom = view.viewBorderBottom
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        _binding = ItemListActividadInFragmentRecibirBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(_binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.tv_title.text = actividads[position].title
        holder.tv_des.text = actividads[position].description
        holder.tv_monney.text = "${actividads[position].monney}€"

        when{
            position == actividads.size - 1 -> {
                holder.view_bottom.visibility = View.INVISIBLE
                holder.tv_monney.setTextColor(Color.parseColor("#00c55b"))
            }
            actividads[position].monney > 0 -> {
                holder.tv_monney.setTextColor(Color.parseColor("#00c55b"))
            }
        }
    }

    override fun getItemCount(): Int {
        return actividads.size
    }
}