package com.fatihakbulut.video_view

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fatihakbulut.video_view.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.buttonBasla.setOnClickListener {

            val adres = Uri.parse("android.resource://"+packageName+"/"+R.raw.video)
            binding.videoView.setVideoURI(adres)
            binding.videoView.start()
        }

        binding.buttonDur.setOnClickListener {

            binding.videoView.stopPlayback()


        }

    }
}