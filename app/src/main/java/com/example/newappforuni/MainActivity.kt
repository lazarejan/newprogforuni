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

//        binding.nextButton1.setOnClickListener {  }
        binding.apply {
            nextButton1.setOnClickListener {
                val name = nameET.text.toString()
                val age = ageET.text.toString()

                val intent = Intent(this@MainActivity, MainActivity2::class.java)

                intent.putExtra("NAME", name)
                intent.putExtra("AGE", age)
                startActivity(intent)
            }
        }
    }
}