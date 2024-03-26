package com.fatihakbulut.kisileruygulamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.fatihakbulut.kisileruygulamasi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var kisilerListe: ArrayList<Kisiler>
    private lateinit var adapter: KisilerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Toolbar işlemleri
        binding.toolbar.title = "Kişiler Uygulaması"
        setSupportActionBar(binding.toolbar)

        // RecyclerView işlemleri
        binding.rv.setHasFixedSize(true) // RV'ın daha iyi görünmesini sağlar.
        binding.rv.layoutManager = LinearLayoutManager(this) // RecyclerView yapısının alta alta görünmesini sağlayan kodlama

        // Veri kümesinin oluşturulması
        kisilerListe = ArrayList()
        val k1 = Kisiler(1,"Ahmet","888888")
        val k2 = Kisiler(2,"Zeynep","666666")

        kisilerListe.add(k1)
        kisilerListe.add(k2)

        // Veri kümesinin adapter sınıfına aktarılması
        adapter = KisilerAdapter(this,kisilerListe)

        // Adapter nesnesinin RecyclerView'a aktarılması
        binding.rv.adapter = adapter

        // Floating Action button işlemleri
        binding.fab.setOnClickListener {

        }
    }
}