package com.fatihakbulut.workmanagerkullanimi

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker(mContext:Context,workerParams: WorkerParameters): Worker(mContext,workerParams) {
    override fun doWork(): Result {
        val toplam = 10 + 20
        Log.e("Arkaplan İşlemi Sonucu", toplam.toString())
        return Result.success() // Başarılı oldu bildirimi
        
    }
}