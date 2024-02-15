package com.fatihakbulut.materialdesigngiris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.fatihakbulut.materialdesigngiris.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.fab.setOnClickListener {
            Toast.makeText(applicationContext, "Merhaba", Toast.LENGTH_SHORT).show()
        }
        
    }
}