package com.fatihakbulut.depolama_islemleri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fatihakbulut.depolama_islemleri.databinding.ActivityMainBinding
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.FileReader
import java.io.FileWriter
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonYaz.setOnClickListener {

            hariciYaz()

        }

        binding.buttonOku.setOnClickListener {

            hariciOku()
        }

        binding.buttonSil.setOnClickListener {

            hariciSil()
        }
    }

    fun hariciYaz(){

        try {

            val yol = applicationContext.getExternalFilesDir(null)?.absoluteFile
            val dosya = File(yol,"dosyam.txt")

            if (!dosya.exists()){
                dosya.createNewFile()
            }

            val fw = FileWriter(dosya)
            val yazici = BufferedWriter(fw)

            yazici.write(binding.editTextGirdi.text.toString())

            yazici.flush()
            yazici.close()
            fw.close()

            binding.editTextGirdi.setText("")


        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    fun hariciOku(){
        try {

            val yol = applicationContext.getExternalFilesDir(null)?.absoluteFile
            val dosya = File(yol,"dosyam.txt")

            val fr = FileReader(dosya)
            val okuyucu = BufferedReader(fr)

            val sb = StringBuilder()
            var satir: String? = null

            while ({satir = okuyucu.readLine();satir}() != null){
                sb.append(satir+"\n")
            }
            okuyucu.close()
            binding.editTextGirdi.setText(sb.toString())



        }catch (e:Exception){
            e.printStackTrace()
        }

    }

    fun  hariciSil(){

        try {

            val yol = applicationContext.getExternalFilesDir(null)?.absoluteFile
            val dosya = File(yol,"dosyam.txt")

            dosya.delete()

        }catch (e:Exception){
            e.printStackTrace()
        }


    }
}