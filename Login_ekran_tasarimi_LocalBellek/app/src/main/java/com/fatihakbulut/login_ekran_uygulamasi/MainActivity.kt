package com.fatihakbulut.login_ekran_uygulamasi

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.fatihakbulut.login_ekran_uygulamasi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sp = getSharedPreferences("GirisBilgi",Context.MODE_PRIVATE)

        binding.buttonGiris.setOnClickListener {

            val kullaniciAdi = binding.editTextKullaniciAdi.text.toString()
            val sifre = binding.editTextSifre.text.toString()

            if (kullaniciAdi == "admin" && sifre == "123"){

                // Kullanıcı adı ve şifreyi shared preferences ile lokal belleğe kaydetme

                val editor = sp.edit()
                editor.putString("kullaniciAdi",kullaniciAdi)
                editor.putString("sifre",sifre)
                editor.commit()


                startActivity(Intent(this@MainActivity, AnaEkranActivity::class.java)) // Main activity'den Ana Ekran activity'e geçme
                finish() // Back  stackten login  ekranının silinmesi

            }else{

                Toast.makeText(applicationContext,"Hatalı Giriş", Toast.LENGTH_SHORT).show()
            }


        }

    }
}