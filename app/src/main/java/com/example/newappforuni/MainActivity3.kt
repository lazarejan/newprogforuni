package com.example.newappforuni

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.newappforuni.databinding.ActivityMain2Binding
import com.example.newappforuni.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {

    lateinit var binding: ActivityMain3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.nameTV.text = intent.getStringExtra("NAME")
        binding.ageTV.text = intent.getIntExtra("AGE", 0).toString()
        binding.checkBoxTV.text = intent.extras?.getBoolean("CHECKBOX").toString()
        binding.switch1TV.text = intent.extras?.getBoolean("SWITCH").toString()




    }
}