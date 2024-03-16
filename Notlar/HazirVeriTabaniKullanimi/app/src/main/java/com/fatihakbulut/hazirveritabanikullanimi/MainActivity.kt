package com.fatihakbulut.hazirveritabanikullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.fatihakbulut.hazirveritabanikullanimi.databinding.ActivityMainBinding
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        veritabaniKopyala()

        val vt = VeritabaniYardimcisi(this)
        //val liste = Kategorilerdao().tumKategoriler(vt)

        val liste = Filmlerdao().tumFilmlerByKategoriId(vt,2)

        for (f in liste){
            Log.e("Film id", f.film_id.toString())
            Log.e("Film Kategori ad", f.film_ad)
            Log.e("Film Kategori yıl", f.film_yil.toString())
            Log.e("Film Kategori resim", f.film_resim)
            Log.e("Film Kategori id", f.kategori.kategori_id.toString())
            Log.e("Film Kategori ad", f.kategori.kategori_ad)
            Log.e("Film yönetmen id", f.yonetmen.yonetmen_id.toString())
            Log.e("Film yönetmen ad", f.yonetmen.yonetmen_ad)

        }

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