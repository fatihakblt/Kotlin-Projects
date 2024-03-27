package com.fatihakbulut.sarjseviyekontroluygulamasi

import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fatihakbulut.sarjseviyekontroluygulamasi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var sarjSeviyeAlgilama: SarjSeviyeAlgilama // SarjSeviyeAlgilama sınıfından boş bir nesne oluşturduk.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sarjSeviyeAlgilama = SarjSeviyeAlgilama() // nesne tanımlandı.



    }

    // Uygulama çalıştığında BATTERY_LOW filtresini yakalar - düşük batarya filtresi(%15 ve altı)**
    override fun onResume() {
        super.onResume()
        val filter = IntentFilter()
        filter.addAction("android.intent.action.BATTERY_LOW")
        // BroadCast aktif edildi
        registerReceiver(sarjSeviyeAlgilama,filter)
    }

    override fun onStop() {
        super.onStop()
        // BroadCast deaktif edildi
        unregisterReceiver(sarjSeviyeAlgilama)
    }
}