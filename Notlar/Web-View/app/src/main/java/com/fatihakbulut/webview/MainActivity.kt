package com.fatihakbulut.webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fatihakbulut.webview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.webView.settings.javaScriptEnabled = true // JavaScript özelliğini aktif ettik

        binding.webView.loadUrl("https://obs.atauni.edu.tr/")
    }
}