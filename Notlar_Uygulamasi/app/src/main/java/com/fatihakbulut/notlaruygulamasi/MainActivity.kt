package com.fatihakbulut.notlaruygulamasi

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.fatihakbulut.notlaruygulamasi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Global nesne tanımlanması
    private lateinit var notlarListe:ArrayList<Notlar>
    private lateinit var adapter: NotlarAdapter
    private lateinit var vt:VeritabaniYardimcisi

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Toolbar işlemleri
        binding.toolbar.title = "Notlar Uygulaması"
        setSupportActionBar(binding.toolbar)

        // RecyclerView işlemleri
        binding.rv.setHasFixedSize(true) // RecyclerView yapısının daha düzenli görünmesi için yapılan kodlama.
        binding.rv.layoutManager = LinearLayoutManager(this) // RecyclerView üzerindeki cardView'lerin görünümünü  lineerLayput ile düzenledik.


        /*// Listeye verilerin eklenmesi
        notlarListe = ArrayList()
        val n1 = Notlar(1,"Tarih",40,80)
        val n2 = Notlar(2,"Kimya",70,50)
        val n3 = Notlar(3,"Fizik",30,60)

        notlarListe.add(n1)
        notlarListe.add(n2)
        notlarListe.add(n3)*/


        // Veritabanı işlemleri
        vt = VeritabaniYardimcisi(this)
        notlarListe = Notlardao().tumNotlar(vt)


        // Adapter ile tasarım bağlantısının kurulması
        adapter = NotlarAdapter(this,notlarListe) // Adapter verilerin nerede ve nasıl görüneceğini organize eder.


        // Adapter'ın bilgileri organize ettikten sonra görüntüleme işleminin yapılması
        binding.rv.adapter = adapter

        // Ortalamanın hesaplanması
        var toplam = 0

        for (n in notlarListe){
            toplam = toplam + (n.not1 + n.not2)/2

        }

        if (toplam != 0){
            binding.toolbar.subtitle = "Ortalama : ${toplam/notlarListe.size}"


        }



        // Floating Action Button işlemleri
        binding.fab.setOnClickListener {

            startActivity(Intent(this@MainActivity,NotKayitActivity::class.java))
        }

    }

    // Geri tuşunun kullanımında optimizasyon yapıldı
    override fun onBackPressed() {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)

    }
}