package com.fatihakbulut.toolbararama

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.widget.SearchView
import com.fatihakbulut.toolbararama.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener { // Menu'deki arama özelliğini atif etmek için kullandığımız interface**** menu_arama'daki ActionView class'a eklendi
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.title ="Arama"
        setSupportActionBar(binding.toolbar)


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_arama, menu) // Menu'nün mainActivity'e bağlanması

        val item = menu.findItem(R.id.action_ara) // item'ı id'si ile yakaladık
        val searchView = item.actionView as SearchView // item'ı arama sınıfından bir nesneye dönüştürdük.
        searchView.setOnQueryTextListener(this) // Arama işlemini tetikledik
        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(query: String?): Boolean { // Arama tuşuna basıldığındaki arama sonucunu veriyor.
        Log.e("onQueryTextSubmit",query!!)

        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean { // Yazılan her harfteki arama sonucu  anlık olarak veriyor
        Log.e("onQueryTextChange",newText!!)
        return true
    }
}