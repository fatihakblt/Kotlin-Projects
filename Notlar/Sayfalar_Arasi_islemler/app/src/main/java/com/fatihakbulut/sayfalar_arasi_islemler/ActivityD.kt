package com.fatihakbulut.sayfalar_arasi_islemler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fatihakbulut.sayfalar_arasi_islemler.databinding.ActivityDBinding
import com.fatihakbulut.sayfalar_arasi_islemler.databinding.ActivityMainBinding

class ActivityD : AppCompatActivity() {
    private lateinit var binding: ActivityDBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_d)
        binding = ActivityDBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonEnd.setOnClickListener {
            val intent = Intent(this@ActivityD,MainActivity::class.java)
            // Finish ile kendinden bir önceki backstack'i siler ve döndüğü aktiviteden kaldığı yerden devam edebilir.
            // Bu kodda D activity'sinden MainActivity'e geçilmiş ve D activty'si Destroy edilmiştir,
            // MainActivity'e geçtikten sonra back tuşuna basılırsa  D'ye değil C  aktivitesine dönüş olur.
            finish()
            startActivity(intent)
        }

    }

    override fun onBackPressed() {
        val intent = Intent(this@ActivityD,ActivityB::class.java)
        /* Bu yapı sayesinde D activity'sinde geri(back) tuşuna bastığımızda B'ye geçerken
         B'den sonra oluşturulumuş activity stack'ini siler yani B'den sonra geçiş yapılmış Activityleri destroy eder. Ve Back Stack'den kaldırır.*/

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

}