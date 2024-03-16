package com.fatihakbulut.bayrakquizuygulamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fatihakbulut.bayrakquizuygulamasi.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}