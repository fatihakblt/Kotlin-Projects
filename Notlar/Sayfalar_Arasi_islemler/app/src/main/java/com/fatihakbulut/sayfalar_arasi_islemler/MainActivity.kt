package com.fatihakbulut.sayfalar_arasi_islemler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fatihakbulut.sayfalar_arasi_islemler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // A sayfasındaki buttona tıklandığında B sayfasına geçiş yapılır.
        binding.buttonGoToB.setOnClickListener{

            // Nesneler ile veri aktarımının yapılması

            val kisi = Kisiler(999999,"Fatih",1.78)



            val yeniIntent = Intent(this@MainActivity, ActivityB::class.java)

            // Sayfalar arası veri taşıma işlemi  Main -> B ' ye veri aktarımı

            yeniIntent.putExtra("mesaj", "merhaba") // key = mesaj, value = "merhaba"
            yeniIntent.putExtra("yas",23) // key = yas, value = 23
            yeniIntent.putExtra("boy",1.78) // key= boy, value = 1.78
            // nesne gönderme
            yeniIntent.putExtra("nesne",kisi)

            startActivity(yeniIntent)
        }


    }
}