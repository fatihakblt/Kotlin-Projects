package com.fatihakbulut.button_textview_edittext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fatihakbulut.button_textview_edittext.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button.setOnClickListener {
            val alinanVeri = binding.editTextText.text
            binding.textView.text = alinanVeri.toString()

        }
    }
}