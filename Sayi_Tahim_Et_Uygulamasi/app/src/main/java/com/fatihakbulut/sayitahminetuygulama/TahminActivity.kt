package com.fatihakbulut.sayitahminetuygulama

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.fatihakbulut.sayitahminetuygulama.databinding.ActivityTahminBinding
import kotlin.random.Random

class TahminActivity : AppCompatActivity() {
    // Rastgele sayı üretme ve sayaç global değişkenleri
    private var rastgeleSayi = 0
    private var sayac = 5


    private lateinit var binding: ActivityTahminBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTahminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rastgeleSayi = Random.nextInt(101) // 0 ile 100 arası rastgele sayı üretimi

        Log.e("Rastgele Sayı", rastgeleSayi.toString()) // Tahmin edilen sayının testi için konsola bilgi verilmesi


        binding.buttonTahmin.setOnClickListener {


            //val intent = Intent(this@TahminActivity,SonucActivity:: class.java)
            //finish()
            //startActivity(intent)

            
        }
    }
}