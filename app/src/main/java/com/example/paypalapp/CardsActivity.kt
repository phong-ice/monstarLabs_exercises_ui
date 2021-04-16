package com.example.paypalapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.paypalapp.adapter.AdapterCards
import com.example.paypalapp.databinding.ActivityCardsBinding
import com.example.paypalapp.model.Card

class CardsActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityCardsBinding
    private lateinit var adapterCards: AdapterCards
    private lateinit var cards: ArrayList<Card>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityCardsBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        cards = arrayListOf()
        cards.add(Card(1, R.mipmap.mastercard_2, "Mastercard", "****9889"))
        cards.add(Card(2, R.mipmap.combined_shape, "Visa black", "****8764"))
        cards.add(Card(3, R.mipmap.combined_shape, "Visa black", "****8764"))
        adapterCards = AdapterCards(this, cards)
        _binding.lvCards.apply {
            layoutManager = LinearLayoutManager(this@CardsActivity)
            adapter = adapterCards
        }
        _binding.buttomBack.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}