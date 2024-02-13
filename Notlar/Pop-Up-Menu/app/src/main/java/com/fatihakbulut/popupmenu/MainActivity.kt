package com.fatihakbulut.popupmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.PopupMenu
import com.fatihakbulut.popupmenu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonMenuAc.setOnClickListener {
            val popup = PopupMenu(this@MainActivity,binding.buttonMenuAc) // İkinci değişken hangi görsel nesnenin popup menusunu açacağını ifade eder.
            popup.menuInflater.inflate(R.menu.popup_menu,popup.menu)

            popup.show()
        }

    }
}