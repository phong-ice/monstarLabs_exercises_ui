package com.example.paypalapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.paypalapp.R
import com.example.paypalapp.databinding.ItemListPersonInFragmentRecibirBinding
import com.example.paypalapp.model.Person

class AdapterPerson(val context: Context, val persons: ArrayList<Person>) :
    RecyclerView.Adapter<AdapterPerson.ViewHolder>() {

    private lateinit var _binding: ItemListPersonInFragmentRecibirBinding

    class ViewHolder(view: ItemListPersonInFragmentRecibirBinding) :
        RecyclerView.ViewHolder(view.root) {
        val img_avatar = view.imgAvatar
        val tv_name = view.tvName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        _binding = ItemListPersonInFragmentRecibirBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ViewHolder(_binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.img_avatar.setImageResource(persons[position].avatar)
        holder.tv_name.text = persons[position].name
    }

    override fun getItemCount(): Int {
        return persons.size
    }
}