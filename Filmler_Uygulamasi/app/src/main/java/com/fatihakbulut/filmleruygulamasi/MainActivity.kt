package com.fatihakbulut.filmleruygulamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.fatihakbulut.filmleruygulamasi.databinding.ActivityMainBinding
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper

class MainActivity : AppCompatActivity() {
    private lateinit var kategoriListe:ArrayList<Kategoriler>
    private lateinit var adapter: KategoriAdapter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Veritabanı kopyalama işlemi
        veritabaniKopyala()

        // Toolbar işlemler
        binding.toolbarKategori.title = "Kategoriler"
        setSupportActionBar(binding.toolbarKategori)

        // RecyclerView'in daha güzel görünmesini sağlar.
        binding.kategoriRv.setHasFixedSize(true)

        // RecyclerView üzerindeki cardların görüntüleme biçimini ayarladık.
        binding.kategoriRv.layoutManager = LinearLayoutManager(this)

        kategoriListe = ArrayList()

        val k1 = Kategoriler(1,"Komedi")
        val k2 = Kategoriler(2,"Bilim Kurgu")
        val k3 = Kategoriler(3,"Korku")

        kategoriListe.add(k1)
        kategoriListe.add(k2)
        kategoriListe.add(k3)

        // Adapter sınıfına context ve kategori listelerinin gönderilmesi ve adapter nesnesine gerekli bilgilerin aktarılması
        adapter = KategoriAdapter(this, kategoriListe)

        // adapter nesnesindeki verilerin kategoriRv tasarım nesnesine aktarılması
        binding.kategoriRv.adapter = adapter

    }


    fun veritabaniKopyala(){
        val copyHelper = DatabaseCopyHelper(this)

        try {
            copyHelper.createDataBase()
            copyHelper.openDataBase()

        }catch (e:Exception){
            e.printStackTrace()
        }
    }
}