package com.fatihakbulut.login_ekran_uygulamasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fatihakbulut.login_ekran_uygulamasi.databinding.ActivityAnaEkranBinding

class AnaEkranActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAnaEkranBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnaEkranBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCikisYap.setOnClickListener {

            startActivity(Intent(this@AnaEkranActivity,MainActivity::class.java))
            finish()
        }
    }
}