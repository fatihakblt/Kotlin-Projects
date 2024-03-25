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
    private lateinit var vt : VeritabaniYardimcisi
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


        // Veritabanındaki bilgilerin kategoriListe'ye aktarılması
        vt = VeritabaniYardimcisi(this)
        kategoriListe = Kategorilerdao().tumKategoriler(vt)

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