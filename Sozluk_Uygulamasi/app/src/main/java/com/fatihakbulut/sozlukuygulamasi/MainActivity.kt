package com.fatihakbulut.sozlukuygulamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.fatihakbulut.sozlukuygulamasi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var kelimelerListe:ArrayList<Kelimeler> // Veri kümemiz
    private lateinit var adapter: KelimelerAdapter // Adapter sınıfından boş bir nesne oluşturduk.

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.title = "Sözlük Uygulaması"
        setSupportActionBar(binding.toolbar)

        binding.rv.setHasFixedSize(true)
        binding.rv.layoutManager = LinearLayoutManager(this)

        kelimelerListe = ArrayList()
        val k1 = Kelimeler(1,"Dog","Köpek")
        val k2 = Kelimeler(2,"Fish","Balık")
        val k3 = Kelimeler(3,"Table","Masa")
        kelimelerListe.add(k1)
        kelimelerListe.add(k2)
        kelimelerListe.add(k3)

        adapter = KelimelerAdapter(this,kelimelerListe)
        binding.rv.adapter = adapter

    }
}