package com.fatihakbulut.sayfalar_arasi_islemler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.window.OnBackInvokedDispatcher
import com.fatihakbulut.sayfalar_arasi_islemler.databinding.ActivityCBinding
import com.fatihakbulut.sayfalar_arasi_islemler.databinding.ActivityMainBinding

class ActivityC : AppCompatActivity() {
    private lateinit var binding: ActivityCBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)
        binding = ActivityCBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Butona tıklandığında D aktivitesine geçiş yapılır
        binding.buttonGoToD.setOnClickListener {
            val intent = Intent(this@ActivityC,ActivityD::class.java)
            startActivity(intent)
        }
    }



    // Back tuşuna basıldığında C sayfasından A sayfasına geçiş yapılır.
    override fun onBackPressed() {
        val yeniIntent = Intent(this@ActivityC,MainActivity::class.java)
            startActivity(yeniIntent)
    }
}