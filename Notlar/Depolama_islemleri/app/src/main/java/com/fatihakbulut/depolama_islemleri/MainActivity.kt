package com.fatihakbulut.depolama_islemleri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fatihakbulut.depolama_islemleri.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        
    }
}