package com.example.paypalapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.paypalapp.databinding.ItemListCardsBinding
import com.example.paypalapp.model.Card

class AdapterCards(var context: Context,val cards:ArrayList<Card>):RecyclerView.Adapter<AdapterCards.ViewHolder>() {

    private lateinit var _binding:ItemListCardsBinding

    class ViewHolder(view:ItemListCardsBinding):RecyclerView.ViewHolder(view.root) {
        var img = view.imgCards
        var tv_name = view.tvNameCards
        var tv_number = view.tvNumberCards
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        _binding = ItemListCardsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(_binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.img.setImageResource(cards[position].avatar)
        holder.tv_name.text = cards[position].name
        holder.tv_number.text = cards[position].number.toString()
    }

    override fun getItemCount(): Int {
        return cards.size
    }
}