package com.fatihakbulut.progressbar_slider_ratingbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fatihakbulut.progressbar_slider_ratingbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}