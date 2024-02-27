package com.fatihakbulut.sqlite_kullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fatihakbulut.sqlite_kullanimi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}