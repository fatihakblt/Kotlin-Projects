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

        val sonuc = intent.getBooleanExtra("sonuc",false) // Doğru sonuç gelemez ise false olur.
        val tutulanSayi = intent.getIntExtra("sayi",0)

        if (sonuc){
            binding.textViewSonuc.text = "KAZANDINIZ"
            binding.textViewSayi.text = "Tutulan sayı:" +tutulanSayi.toString()
            binding.imageViewSonuc.setImageResource(R.drawable.mutlu1)
        }else{
            binding.textViewSonuc.text = "KAYBETTİNİZ"
            binding.textViewSayi.text = "Tutulan sayı:" +tutulanSayi.toString()
            binding.imageViewSonuc.setImageResource(R.drawable.uzgun)
        }

        binding.buttonTekrar.setOnClickListener {

            val intent = Intent(this@SonucActivity,TahminActivity:: class.java)
            finish()
            startActivity(intent)
        }
    }
}