package com.example.newappforuni

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.newappforuni.databinding.ActivityMain2Binding
import com.example.newappforuni.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {

    lateinit var binding: ActivityMain2Binding

    private var basePrice: Double = 0.0
    private var finalPrice: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val itemName = intent.getStringExtra("itemName")
        basePrice = intent.getDoubleExtra("itemPrice", 0.0)

        binding.itemName.text = itemName
        binding.basePrice.text = "Price: $$basePrice"

        calculateTotal()

        binding.shippingGroup.setOnCheckedChangeListener { _, _ ->
            calculateTotal()
        }

        binding.payBtn.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }
    }

    private fun calculateTotal() {
        // 5% discount
        val discountPrice = basePrice * 0.95

        finalPrice = discountPrice

        // Express shipping
        if (binding.express.isChecked) {
            finalPrice += 1700
        }

        binding.totalPrice.text = "Total: $${"%.2f".format(finalPrice)}"
    }
}