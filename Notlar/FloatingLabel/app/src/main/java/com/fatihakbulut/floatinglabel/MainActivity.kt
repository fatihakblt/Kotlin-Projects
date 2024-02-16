package com.fatihakbulut.floatinglabel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.fatihakbulut.floatinglabel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonYap.setOnClickListener {
            // Alınan metinlerdeki boşlukları silmek için trim metodu kullanıldı.(whitespace boşlukların silinmesi)
            val ad = binding.editTextAd.text.toString().trim()
            val tel = binding.editTextTel.text.toString().trim()


            Toast.makeText(this@MainActivity,"$ad - $tel",Toast.LENGTH_SHORT).show()
        }
    }
}