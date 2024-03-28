package com.fatihakbulut.durumabaglibildirim

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import com.fatihakbulut.durumabaglibildirim.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonBildir.setOnClickListener {
            val builder : NotificationCompat.Builder

            val bildirimYoneticisi = applicationContext
                .getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            // Bildirime tıkladığımızda nereye geçiş yapılacak
            val intent = Intent(this,MainActivity::class.java)
            val gidilecekIntent = PendingIntent.getActivity(applicationContext,1,intent,PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)

            // Oreo sürümü ve üzeri sürümlerde burası çalışır
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

                val kanalId = "kanalId"
                val kanalAd = "kanalAd"
                val kanalTanitim = "kanalTanıtım"
                val kanalOnceligi = NotificationManager.IMPORTANCE_HIGH

                var kanal :NotificationChannel? = bildirimYoneticisi.getNotificationChannel(kanalId)

                if (kanal == null){
                    kanal = NotificationChannel(kanalId,kanalAd,kanalOnceligi)
                    kanal.description = kanalTanitim
                    bildirimYoneticisi.createNotificationChannel(kanal)
                }


                builder = NotificationCompat.Builder(this,kanalId)

                builder.setContentTitle("Başlık")
                    .setContentText("İçerik")
                    .setSmallIcon(R.drawable.resim)
                    .setContentIntent(gidilecekIntent)
                    .setAutoCancel(true)
            }
            // Eski sürümlerde burası çalışır
            else{
                builder = NotificationCompat.Builder(this)

                builder.setContentTitle("Başlık")
                        .setContentText("İçerik")
                        .setSmallIcon(R.drawable.resim)
                        .setContentIntent(gidilecekIntent)
                        .setAutoCancel(true)
                        .priority = Notification.PRIORITY_HIGH
            }
            bildirimYoneticisi.notify(1,builder.build())

        }
    }
}