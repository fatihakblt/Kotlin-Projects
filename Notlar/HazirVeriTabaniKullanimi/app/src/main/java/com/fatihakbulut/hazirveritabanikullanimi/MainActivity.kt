package com.fatihakbulut.hazirveritabanikullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fatihakbulut.hazirveritabanikullanimi.databinding.ActivityMainBinding
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        veritabaniKopyala()

    }

    // Veritabanını kopyalama işlemini yapan fonksiyon
    fun veritabaniKopyala(){

        val db = DatabaseCopyHelper(this)

        try {
            db.createDataBase() // Bu uygulama hangi telefonda çalışıyorsa o telefonda filmler.sqlite veritabanını kopyalar.
        }catch (e:Exception){
            e.printStackTrace() // Hata sonucunu açıklamalı olarak verir.
        }

        try {
            db.openDataBase()// Bu uygulama hangi telefonda çalışıyorsa o telefonda filmler.sqlite veritabanını aktif hale getirir.
        }catch (e:Exception){
            e.printStackTrace() // Hata sonucunu açıklamalı olarak verir.
        }
    }
}