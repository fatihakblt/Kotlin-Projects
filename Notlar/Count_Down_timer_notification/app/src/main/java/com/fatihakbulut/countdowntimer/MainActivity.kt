package com.fatihakbulut.countdowntimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.fatihakbulut.countdowntimer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonBasla.setOnClickListener {
            val sayici = object : CountDownTimer(30000,1000) { // 30 saniyeden 1'er saniye aralıklarla çalısacak zamanlayıcı

                override fun onTick(i: Long) { // Her azalmada çalışan metod

                    binding.textViewCikti.text = "Kalan Süre : ${i/1000} sn"
                }

                override fun onFinish() { // İşlem bittiğinde çalışan metod

                    binding.textViewCikti.text = "Bitti"
                }
            }

            sayici.start() // Sayıcıyı başlattık.
        }
    }
}