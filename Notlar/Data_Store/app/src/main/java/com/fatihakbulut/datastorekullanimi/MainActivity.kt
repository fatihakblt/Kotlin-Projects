package com.fatihakbulut.datastorekullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.fatihakbulut.datastorekullanimi.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val ap =  AppPref(this)
        val job = CoroutineScope(Dispatchers.Main).launch {
           // Kayıt
            ap.kayitAd("Ahmet")
            ap.kayitYas(23)
            ap.kayitBoy(1.78)
            ap.kayitBekar(true)

            // Liste Kayıt
            val liste = HashSet<String>()
            liste.add("Mehmet")
            liste.add("Zeynep")

            ap.kayitArkadasListe(liste)


            // Okuma
            val gelenAd = ap.okuAd()
            val gelenYas = ap.okuYas()
            val gelenBoy = ap.okuBoy()
            val gelenBekar = ap.okuAd()

            Log.e("Gelen Ad", gelenAd)
            Log.e("Gelen Yaş", gelenYas.toString())
            Log.e("Gelen Boy", gelenBoy.toString())
            Log.e("Gelen Bekar", gelenBekar.toString())

            // Liste okuma

            val gelenListe = ap.okuArkadasListe()

            if (gelenListe != null){
                for (a in gelenListe){
                    Log.e("Gelen Arkadaş", a)
                }
            }
        }
    }
}