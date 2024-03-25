package com.fatihakbulut.notlaruygulamasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.fatihakbulut.notlaruygulamasi.databinding.ActivityNotKayitBinding
import com.google.android.material.snackbar.Snackbar

class NotKayitActivity : AppCompatActivity() {
    private lateinit var vt:VeritabaniYardimcisi

    private lateinit var binding: ActivityNotKayitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotKayitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vt = VeritabaniYardimcisi(this)
        // Toolbar işlemleri
        binding.toolbarNotKayit.title =  "Not Kayıt"
        setSupportActionBar(binding.toolbarNotKayit)

        //
        binding.buttonKaydet.setOnClickListener {
            // Edittext'e yazılan verilere ulaşıldı.
            val ders_adi = binding.editTextDers.text.toString().trim()
            val not1 = binding.editTextNot1.text.toString().trim()
            val not2 = binding.editTextNot2.text.toString().trim()


            // EditTextlerin boş olma durumu kontrolü yapıldı. Boş ise kayıt işlemi yapılmaz
            if (TextUtils.isEmpty(ders_adi)){
                Snackbar.make(binding.toolbarNotKayit,"Ders adı giriniz",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(not1)){
                Snackbar.make(binding.toolbarNotKayit,"1. Notu giriniz",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(not2)){
                Snackbar.make(binding.toolbarNotKayit,"2. Notu giriniz",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Not kayıt işleminin yapılması
            Notlardao().notEkle(vt,ders_adi, not1.toInt(),not2.toInt())

            startActivity(Intent(this@NotKayitActivity,MainActivity::class.java))
            finish()
        }

    }
}