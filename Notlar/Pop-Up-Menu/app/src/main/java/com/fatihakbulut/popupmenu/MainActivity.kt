package com.fatihakbulut.popupmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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

            // Menu'den yapılan seçimi yakalama
            popup.setOnMenuItemClickListener {item ->
                when(item.itemId){
                    R.id.action_sil -> {
                        Toast.makeText(applicationContext,"Sil seçildi",Toast.LENGTH_SHORT).show()
                        true// Bu ifade click listener'a gönderiliyor ve bu item'a tıklanıldığı anlaşılıyor.

                    }

                    R.id.action_duzenle ->{
                        Toast.makeText(applicationContext,"Düzenle seçildi",Toast.LENGTH_SHORT).show()
                        true

                    }
                    else -> false // Bu ifade click listener'a gönderiliyor ve bu item'a tıklanılmadığı!!! anlaşılıyor.

                }
            }

            popup.show()
        }

    }
}