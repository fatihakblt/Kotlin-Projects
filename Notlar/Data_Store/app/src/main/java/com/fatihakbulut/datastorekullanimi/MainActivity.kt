package com.fatihakbulut.datastorekullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.fatihakbulut.datastorekullanimi.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val ap =  AppPref(this)
        val job = CoroutineScope(Dispatchers.Main).launch {
            ap.kayitAd("Ahmet")

            val gelenAd = ap.okuAd()
            Log.e("Gelen Ad", gelenAd)

        }

    }
}