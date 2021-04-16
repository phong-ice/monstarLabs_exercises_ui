package com.example.paypalapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.paypalapp.databinding.ActivityPayBinding

class PayActivity : AppCompatActivity() {

    private lateinit var _binding:ActivityPayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityPayBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        _binding.btnBack.setOnClickListener {
            onBackPressed()
        }
        _binding.button2.setOnClickListener {
            startActivity(Intent(this@PayActivity,CardsActivity::class.java))
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}