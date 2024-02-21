package com.fatihakbulut.shared_preferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fatihakbulut.shared_preferences.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        
    }
}