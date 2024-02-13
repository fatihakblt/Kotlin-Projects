package com.fatihakbulut.toastmesaj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import com.fatihakbulut.toastmesaj.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        // Normal Toast mesaj
        binding.buttonNormal.setOnClickListener {
            Toast.makeText(applicationContext,"Merhaba", Toast.LENGTH_SHORT).show()
        }

        // Özelleştirilmiş Toast mesaj
        binding.buttonOzel.setOnClickListener {
            val tasarim = layoutInflater.inflate(R.layout.toast_tasarim,null) // Oluşturulan tasarıma eriştik.
            val textViewMesaj = tasarim.findViewById(R.id.textViewMesaj) as TextView

            textViewMesaj.text = "Merhaba ÖZel Mesaj"
            val toastOzel = Toast(applicationContext)
            toastOzel.view = tasarim
            toastOzel.setGravity(Gravity.CENTER_HORIZONTAL or Gravity.CENTER_VERTICAL, 0,0)
            toastOzel.duration = Toast.LENGTH_LONG
            toastOzel.show()

        }
    }
}