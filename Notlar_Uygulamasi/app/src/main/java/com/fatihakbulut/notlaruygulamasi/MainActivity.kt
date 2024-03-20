package com.fatihakbulut.notlaruygulamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.fatihakbulut.notlaruygulamasi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Global nesne tanımlanması
    private lateinit var notlarListe:ArrayList<Notlar>
    private lateinit var adapter: NotlarAdapter

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Toolbar işlemleri
        binding.toolbar.title = "Notlar Uygulaması"
        binding.toolbar.subtitle = "Ortalama : 60"
        setSupportActionBar(binding.toolbar)

        // RecyclerView işlemleri
        binding.rv.setHasFixedSize(true) // RecyclerView yapısının daha düzenli görünmesi için yapılan kodlama.
        binding.rv.layoutManager = LinearLayoutManager(this) // RecyclerView üzerindeki cardView'lerin görünümünü  lineerLayput ile düzenledik.


        // Listeye verilerin eklenmesi
        notlarListe = ArrayList()
        val n1 = Notlar(1,"Tarih",40,80)
        val n2 = Notlar(2,"Kimya",70,50)
        val n3 = Notlar(3,"Fizik",30,60)

        notlarListe.add(n1)
        notlarListe.add(n2)
        notlarListe.add(n3)


        // Adapter ile tasarım bağlantısının kurulması
        adapter = NotlarAdapter(this,notlarListe) // Adapter verilerin nerede ve nasıl görüneceğini organize eder.


        // Adapter'ın bilgileri organize ettikten sonra görüntüleme işleminin yapılması
        binding.rv.adapter = adapter


        // Floating Action Button işlemleri
        binding.fab.setOnClickListener {

        }

    }
}