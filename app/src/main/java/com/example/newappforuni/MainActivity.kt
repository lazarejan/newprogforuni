package com.example.newappforuni

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.newappforuni.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.mercedesBtn.setOnClickListener {
            openPayment("Mercedes CLA", 46400.0)
        }

        binding.porscheBtn.setOnClickListener {
            openPayment("Porsche 911", 189000.0)
        }

        binding.ferrariBtn.setOnClickListener {
            openPayment("Ferrari 488", 260000.0)
        }
    }

    private fun openPayment(name: String, price: Double) {
        val intent = Intent(this@MainActivity, MainActivity2::class.java)
        intent.putExtra("itemName", name)
        intent.putExtra("itemPrice", price)
        startActivity(intent)
    }
}