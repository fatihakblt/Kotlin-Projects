package com.fatihakbulut.sayfalar_arasi_islemler

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.fatihakbulut.sayfalar_arasi_islemler.databinding.ActivityBBinding
import com.fatihakbulut.sayfalar_arasi_islemler.databinding.ActivityMainBinding

class ActivityB : AppCompatActivity() {
    private lateinit var binding: ActivityBBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
        binding = ActivityBBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //

        // Main'den gelen verileri almak için:

        val gelenMesaj = intent.getStringExtra("mesaj")
        val gelenYas = intent.getIntExtra("yas", 0) // veri aktarımında sorun olusra 0 değerini alır.
        val gelenBoy = intent.getDoubleExtra("boy",0.0)

        // Verilerin konsolda görüntülenmesi

        Log.e("MESAJ", gelenMesaj.toString())
        Log.e("YAŞ",gelenYas.toString())
        Log.e("BOY",gelenBoy.toString())

        // Gelen nesneyi alma
        val gelenKisiNesnesi = intent.getSerializableExtra("nesne") as Kisiler // Kisiler sınıfından nesne öğesini al

        // Terminale yazdırılması
        Log.e("KİŞİ TCNO",(gelenKisiNesnesi.tcno).toString())
        Log.e("KİŞİ İSİM", gelenKisiNesnesi.isim)
        Log.e("KİŞİ BOY",(gelenKisiNesnesi.boy).toString())

        // B sayfasından C sayfasına geçiş yapılır.
        binding.buttonGoToC.setOnClickListener {

            val yeniIntent = Intent(this@ActivityB, ActivityC::class.java)
            startActivity(yeniIntent)
        }

    }

    // Back tuşuna basldığında uygulamadan çıkma
    override fun onBackPressed() {

        val yeniIntent = Intent(Intent.ACTION_MAIN)
        yeniIntent.addCategory(Intent.CATEGORY_HOME)
        yeniIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(yeniIntent)

    }
}