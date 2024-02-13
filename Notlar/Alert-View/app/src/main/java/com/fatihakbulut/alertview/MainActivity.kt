package com.fatihakbulut.alertview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.fatihakbulut.alertview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Basit AlertView  oluşturma
        binding.buttonNormal.setOnClickListener {
            val ad = AlertDialog.Builder(this@MainActivity)

            ad.setMessage("Mesaj")
            ad.setTitle("Başlık")
            ad.setIcon(R.drawable.resim)

            ad.setPositiveButton("Tamam"){dialogInterface, i->

                Toast.makeText(applicationContext,"Tamam Tıklanıldı", Toast.LENGTH_SHORT).show()
            }

            ad.setNegativeButton("İptal"){dialogInterface, i->

                Toast.makeText(applicationContext,"İptal Tıklanıldı", Toast.LENGTH_SHORT).show()

            }

            ad.create().show()


        }

        binding.buttonOzel.setOnClickListener {


        }

    }
}