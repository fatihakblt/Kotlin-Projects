package com.fatihakbulut.snackbar

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

        binding.buttonGeriDonus.setOnClickListener {


        }

        binding.buttonOzel.setOnClickListener {


        }
    }
}