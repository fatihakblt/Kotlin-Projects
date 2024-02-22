package com.fatihakbulut.login_ekran_uygulamasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fatihakbulut.login_ekran_uygulamasi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.buttonGiris.setOnClickListener {
            startActivity(Intent(this@MainActivity, AnaEkranActivity::class.java)) // Main activity'den Ana Ekran activity'e geçme
            finish() // Back  stackten login  ekranının silinmesi
        }
    }
}