package com.fatihakbulut.recycler_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.fatihakbulut.recycler_view.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var ulkelerList: ArrayList<Ulkeler>
    private lateinit var adapter: RVAdapter

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rv.setHasFixedSize(true) // Tasarım üzerine oturmasını sağlar.
        //binding.rv.layoutManager = LinearLayoutManager(this) // Listenin görünümünü belirteceğiz

        binding.rv.layoutManager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL)
        val u1= Ulkeler(1,"Türkiye")
        val u2= Ulkeler(2,"İtalya")
        val u3= Ulkeler(3,"Fransa")
        val u4= Ulkeler(4,"Rusya")


        ulkelerList = ArrayList<Ulkeler>()
        ulkelerList.add(u1)
        ulkelerList.add(u2)
        ulkelerList.add(u3)
        ulkelerList.add(u4)


        adapter = RVAdapter(this,ulkelerList)

        binding.rv.adapter = adapter




    }
}