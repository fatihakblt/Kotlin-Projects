package com.fatihakbulut.tablayoutkullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.fatihakbulut.tablayoutkullanimi.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val fragmentListesi = ArrayList<Fragment>()
    private val fragmentBaslikListesi = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Fragmentlar listeye eklendi.
        fragmentListesi.add(FragmentBirinci())
        fragmentListesi.add(FragmentIkinci())
        fragmentListesi.add(FragmentUcuncu())

        // View Pager'a ulaşma
        val adapter  = MYViewPagerAdapter(this)
        binding.viewPager2.adapter = adapter

        // View Pager için tab başlıkları oluşturulup listeye eklendi
        fragmentBaslikListesi.add("Bir")
        fragmentBaslikListesi.add("İki")
        fragmentBaslikListesi.add("Üç")

        // Tablayout ile viewPager2 'nin birbiriyle uyumlu çalışması için TabLayoutMediator kullanıldı.
        TabLayoutMediator(binding.tabLayout,binding.viewPager2){ tab, position ->
            tab.setText(fragmentBaslikListesi[position]) // İndeks numarasına göre baslikListesindeki tab başlıkları atanmış oluyor

        }.attach()

        // .attach() ile tabloyout ile viewpager birleştirilmiş oluyor senkronize çalışması sağlanıyor.

    }

    inner class MYViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity){
        override fun getItemCount(): Int {
            return fragmentListesi.size

        }

        override fun createFragment(position: Int): Fragment {

            return fragmentListesi[position]

        }

    }
}