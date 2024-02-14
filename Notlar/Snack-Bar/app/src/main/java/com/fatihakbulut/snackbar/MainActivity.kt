package com.fatihakbulut.snackbar

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fatihakbulut.snackbar.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonNormal.setOnClickListener {view->

            Snackbar.make(view,"Merhaba",Snackbar.LENGTH_SHORT).show() // SnackBar hangi görsel nesneyi çalıştıracaksa ilk değişken olarak o verilir View değişkeni buttonNormal'i  temsil eder

        }

        binding.buttonGeriDonus.setOnClickListener {x ->

            Snackbar.make(x, "Mesaj Silinsin mi?", Snackbar.LENGTH_SHORT)
                .setAction("Evet"){y->
                    Snackbar.make(y,"Mesaj Silindi", Snackbar.LENGTH_SHORT).show()
                }
                .show()

        }

        binding.buttonOzel.setOnClickListener {z->
            val sb = Snackbar.make(z,"İnternet Bağlantısı Yok!", Snackbar.LENGTH_LONG)
            sb.setAction("Tekrar Dene"){t->

                Snackbar.make(t,"Bağlantı kuruldu.",Snackbar.LENGTH_SHORT).show()

            }
            sb.setActionTextColor(Color.RED)
            sb.setTextColor(Color.BLUE)
            sb.setBackgroundTint(Color.WHITE)

            sb.show()


        }
    }
}