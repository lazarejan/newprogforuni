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

        init()


    }

    fun init() = with(binding){
        val name = intent.getStringExtra("NAME")
        val age = intent.getIntExtra("AGE", 0)

        nextButton2.setOnClickListener {
            val intent = Intent(this@MainActivity2, MainActivity3::class.java)

            val checkbox = checkBox.isChecked

            val switch = switch1.isChecked

            intent.putExtra("NAME", name)
            intent.putExtra("AGE", age)
            intent.putExtra("CHECKBOX", checkbox)
            intent.putExtra("SWITCH", switch)
        }

    }
}