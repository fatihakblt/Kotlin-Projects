package com.fatihakbulut.filmleruygulamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fatihakbulut.filmleruygulamasi.databinding.ActivityDetayBinding

class DetayActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetayBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}