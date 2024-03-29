package com.fatihakbulut.workmanagerkullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.fatihakbulut.workmanagerkullanimi.databinding.ActivityMainBinding
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonYap.setOnClickListener {
            val calismaKosulu = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED) // Internet varsa koşulu getirildi.
                .build()

            // Butona bastıkça bir seferlik sonuç getiren yapı
            val istek = OneTimeWorkRequestBuilder<MyWorker>()
                .setInitialDelay(10,TimeUnit.SECONDS) // 10 saniyelik gecikme eklendi
                .setConstraints(calismaKosulu)
                .build()

            WorkManager.getInstance(this).enqueue(istek)

            WorkManager.getInstance(this).getWorkInfoByIdLiveData(istek.id)
                .observe(this){
                    val durum = it.state.name
                    Log.e("Arkaplan İşlem Durumu",durum)
                }
        }
    }
}