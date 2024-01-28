package com.fatihakbulut.sayfalar_arasi_islemler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ActivityD : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_d)
    }

    override fun onBackPressed() {
        val intent = Intent(this@ActivityD,ActivityB::class.java)
        /* Bu yapı sayesinde D activity'sinde geri(back) tuşuna bastığımızda B'ye geçerken
         B'den sonra oluşturulumuş activity stack'ini siler yani B'den sonra geçiş yapılmış Activityleri destroy eder. Ve Back Stack'den kaldırır.*/
         */
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}