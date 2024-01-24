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
            val yeniIntent = Intent(this@MainActivity, ActivityB::class.java)
            startActivity(yeniIntent)
        }


    }
}