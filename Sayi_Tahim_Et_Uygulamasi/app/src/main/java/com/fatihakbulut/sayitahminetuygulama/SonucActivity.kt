package com.fatihakbulut.sayitahminetuygulama

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fatihakbulut.sayitahminetuygulama.databinding.ActivitySonucBinding

class SonucActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySonucBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySonucBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonTekrar.setOnClickListener {

            val intent = Intent(this@SonucActivity,TahminActivity:: class.java)
            finish()
            startActivity(intent)
        }
    }
}