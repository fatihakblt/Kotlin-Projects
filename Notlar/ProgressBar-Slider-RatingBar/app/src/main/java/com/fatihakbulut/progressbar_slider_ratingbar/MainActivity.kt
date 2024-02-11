package com.fatihakbulut.progressbar_slider_ratingbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import com.fatihakbulut.progressbar_slider_ratingbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonBasla.setOnClickListener {

            binding.progressBar.visibility = View.VISIBLE // Görünür

        }

        binding.buttonDur.setOnClickListener {

            binding.progressBar.visibility = View.INVISIBLE // Görünmez
        }


        binding.seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{

            override fun onProgressChanged(seekBar: SeekBar?, ilerleme: Int, fromUser: Boolean) { // anlık sonuc verir (kaydırırken)

                binding.textViewSonuc.text = "Sonuç : $ilerleme"

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {  // Seekbar'a dokunmaya başladığımızda çalışır.

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) { //  Seeknar'ı durdurduğumuzda çalışır.

            }
        } )
    }
}