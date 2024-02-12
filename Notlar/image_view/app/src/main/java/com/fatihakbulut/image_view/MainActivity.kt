package com.fatihakbulut.image_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fatihakbulut.image_view.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonResim1.setOnClickListener {

            // Veri tabanı işlemlerinde dinamik erişim kullanılır.
            binding.imageView.setImageResource(resources.getIdentifier("resim1","drawable",packageName))
        }

        binding.buttonResim2.setOnClickListener {

            binding.imageView.setImageResource(resources.getIdentifier("resim","drawable",packageName))
        }

    }
}