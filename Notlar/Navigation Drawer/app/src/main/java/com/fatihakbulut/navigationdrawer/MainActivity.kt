package com.fatihakbulut.navigationdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.navigation.NavHost
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.fatihakbulut.navigationdrawer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // NavHostFragment ile navigationView' in birlikte çalışmasını sağladık
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        NavigationUI.setupWithNavController(binding.navigationView, navHostFragment.navController)



        // Toolbar'a başlık eklendi.
        binding.toolbar.title = "Başlık"

        // Toggle butonu oluşturuldu, ve drawer ile birlikte senkronize bir şekilde çalışması sağlandı.
        val toggle = ActionBarDrawerToggle(this, binding.drawer,binding.toolbar,0,0)
        binding.drawer.addDrawerListener(toggle)
        toggle.syncState()

    }
}