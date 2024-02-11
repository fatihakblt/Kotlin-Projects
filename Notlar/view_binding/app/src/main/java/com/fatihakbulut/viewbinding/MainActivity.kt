package com.fatihakbulut.viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fatihakbulut.viewbinding.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

// ViewBinding: Görsel nesneleri arayüzden kodlamaya bağlamak için kullandığımız bir yapıdır.
// Data binding ile benzer yapılardır fakat Data Binding genellikle uygulama mimarisinde kullanılan bir yapıdır.


class MainActivity : AppCompatActivity() {
    // Hangi tasarım üzernde çalışılıyorsa binding işlemi yapmak için o tasarım isminin sonuna Binding eklenerek tanımlanır.
    private lateinit var tasarim : ActivityMainBinding // 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = ActivityMainBinding.inflate(layoutInflater) // 2
        setContentView(tasarim.root) // 3


        tasarim.button.setOnClickListener{
            Snackbar.make(it, "Merhaba", Snackbar.LENGTH_LONG).show()
        }

    }
}
