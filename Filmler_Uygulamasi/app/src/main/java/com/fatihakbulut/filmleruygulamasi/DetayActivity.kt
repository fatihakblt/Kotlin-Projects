package com.fatihakbulut.filmleruygulamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fatihakbulut.filmleruygulamasi.databinding.ActivityDetayBinding

class DetayActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Filmler adapter sınıfından gönderilen verilerin alınması
        val film = intent.getSerializableExtra("filmNesne") as Filmler

        binding.textViewDetayFilmAd.text = film.film_ad
        binding.textViewDetayFilmYil.text = (film.film_yil).toString()
        binding.textViewDetayYonetmen.text = (film.yonetmen.yonetmen_ad) // Composition


        binding.imageViewDetayResim.setImageResource(resources.getIdentifier(film.film_resim
            ,"drawable",packageName))


    }
}