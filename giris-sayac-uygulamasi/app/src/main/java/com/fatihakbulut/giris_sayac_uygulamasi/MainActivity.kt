package com.fatihakbulut.giris_sayac_uygulamasi

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fatihakbulut.giris_sayac_uygulamasi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sp = getSharedPreferences("GirisSayici", Context.MODE_PRIVATE) // Bilgilerin kaydedileceği dosya oluşturuldu.

        var sayac = sp.getInt("sayac",0) // (key,varsayılan değer), sayac değerini okuduk.Değer olmadığı için 0 değerini atadı.

        val editor = sp.edit() // Dosya üzerinde silme güncelleme (kayıt işlemi) işlemi yapmak için editor değişkenini oluşturduk.
        editor.putInt("sayac",++sayac) // Sayac değişkenini bir arttırdık.

        editor.commit() // işlemler tamamlandı
        binding.textViewSayac.text = "Açılış Sayısı : $sayac"


    }
}