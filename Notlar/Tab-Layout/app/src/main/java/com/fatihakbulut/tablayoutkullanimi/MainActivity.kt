package com.fatihakbulut.tablayoutkullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.fatihakbulut.tablayoutkullanimi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val fragmentListesi = ArrayList<Fragment>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fragmentListesi.add(FragmentBirinci())
        fragmentListesi.add(FragmentIkinci())
        fragmentListesi.add(FragmentUcuncu())


        // View Pager'a ulaşmaç
        val adapter  = MYViewPagerAdapter(this)
        binding.viewPager2.adapter = adapter



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