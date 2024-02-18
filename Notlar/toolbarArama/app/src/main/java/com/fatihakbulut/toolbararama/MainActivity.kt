package com.fatihakbulut.toolbararama

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.fatihakbulut.toolbararama.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.title ="Arama"
        setSupportActionBar(binding.toolbar)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_arama, menu)
        return super.onCreateOptionsMenu(menu)
    }
}