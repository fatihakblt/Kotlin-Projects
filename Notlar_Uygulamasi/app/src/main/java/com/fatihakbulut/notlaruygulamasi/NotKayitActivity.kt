package com.fatihakbulut.notlaruygulamasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fatihakbulut.notlaruygulamasi.databinding.ActivityNotKayitBinding

class NotKayitActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNotKayitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotKayitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Toolbar işlemleri
        binding.toolbarNotKayit.title =  "Not Kayıt"
        setSupportActionBar(binding.toolbarNotKayit)

        //
        binding.buttonKaydet.setOnClickListener {
            startActivity(Intent(this@NotKayitActivity,MainActivity::class.java))
            finish()
        }

    }
}