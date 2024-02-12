package com.fatihakbulut.video_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fatihakbulut.video_view.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        
    }
}