package com.fatihakbulut.sayitahminetuygulama

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fatihakbulut.sayitahminetuygulama.databinding.ActivityTahminBinding

class TahminActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTahminBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTahminBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonTahmin.setOnClickListener {

            val intent = Intent(this@TahminActivity,SonucActivity:: class.java)
            finish()
            startActivity(intent)
        }
    }
}