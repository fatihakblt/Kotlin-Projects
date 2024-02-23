package com.fatihakbulut.login_ekran_uygulamasi

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fatihakbulut.login_ekran_uygulamasi.databinding.ActivityAnaEkranBinding

class AnaEkranActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAnaEkranBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnaEkranBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Kullanıcı adı ve şifrenin çekilmesi
        val sp = getSharedPreferences("GirisBilgi", Context.MODE_PRIVATE)

        val kullaniciAdi = sp.getString("kullaniciAdi","Kullanıcı adı yok!")
        val sifre = sp.getString("sifre", "Şifre yok!")


        binding.textViewCikti.text = "Kullanıcı Adı : $kullaniciAdi Şifre : $sifre"

        binding.buttonCikisYap.setOnClickListener {

            val editor = sp.edit()
            editor.remove("kullaniciAdi")
            editor.remove("sifre")
            editor.commit()

            startActivity(Intent(this@AnaEkranActivity,MainActivity::class.java))
            finish()
        }
    }
}