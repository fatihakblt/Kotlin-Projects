package com.fatihakbulut.sqlite_kullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fatihakbulut.sqlite_kullanimi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val vt = VeritabaniYardimcisi(this)

        // Veri kaydı işlemi
        Kisilerdao().kisiEkle(vt,"Ahmet", "99999999", 18,1.78) // Kisilerdao sınıfından sanal nesne oluşturulup fonksiyona erişildi.


        

    }
}