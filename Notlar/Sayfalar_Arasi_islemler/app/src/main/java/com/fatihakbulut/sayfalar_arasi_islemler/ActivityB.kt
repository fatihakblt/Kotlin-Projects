package com.fatihakbulut.sayfalar_arasi_islemler

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fatihakbulut.sayfalar_arasi_islemler.databinding.ActivityBBinding
import com.fatihakbulut.sayfalar_arasi_islemler.databinding.ActivityMainBinding

class ActivityB : AppCompatActivity() {
    private lateinit var binding: ActivityBBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
        binding = ActivityBBinding.inflate(layoutInflater)
        setContentView(binding.root)


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