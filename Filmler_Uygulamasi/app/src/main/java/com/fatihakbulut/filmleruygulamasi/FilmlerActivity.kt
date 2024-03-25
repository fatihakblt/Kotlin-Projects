package com.fatihakbulut.filmleruygulamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.fatihakbulut.filmleruygulamasi.databinding.ActivityFilmlerBinding

class FilmlerActivity : AppCompatActivity() {

    private lateinit var filmListe:ArrayList<Filmler>
    private lateinit var adapter: FilmlerAdapter

    private lateinit var binding: ActivityFilmlerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilmlerBinding.inflate(layoutInflater)
        setContentView(binding.root)



        // MainActivit'den gelen kategori verisi alındı
        val kategori = intent.getSerializableExtra("kategoriNesne") as Kategoriler

        binding.toolbarFilmler.title = "Filmler : ${kategori.kategori_ad}"
        setSupportActionBar(binding.toolbarFilmler)

        // rv'in daha iyi görünmesi ve öğeleri grid şeklinde listeleycek
        binding.filmlerRv.setHasFixedSize(true)
        binding.filmlerRv.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL) // Dikeyde 2 li olarak listeleme işlemi yapar -(2 sütun)


        // Veri kümesinin oluşturulması
        filmListe = ArrayList()

        val k = Kategoriler(1,"Dram")
        val y = Yonetmenler(1,"Quentin Tarantino")

        val f1 = Filmler(1,"Django",2008,"django",k,y)
        val f2 = Filmler(2,"Inception",2009,"inception",k,y)
        val f3 = Filmler(3,"The Pianist",2010,"thepianist",k,y)

        filmListe.add(f1)
        filmListe.add(f2)
        filmListe.add(f3)


        adapter = FilmlerAdapter(this,filmListe)
        binding.filmlerRv.adapter = adapter

    }
}