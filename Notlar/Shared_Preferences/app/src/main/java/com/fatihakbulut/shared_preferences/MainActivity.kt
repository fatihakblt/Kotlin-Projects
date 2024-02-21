package com.fatihakbulut.shared_preferences

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fatihakbulut.shared_preferences.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val sp = getSharedPreferences("KişiselBilgiler", Context.MODE_PRIVATE)

        val editor = sp.edit()

        // Lokal bellekteki verinin silinmesi için "key" değerinin verilmesi yeterlidir.
        editor.remove("ad")

        // İşlemin gerçekleştirilmesi için commit() edilmesi gerekli.
        editor.commit()

        /*editor.putString("ad","Ahmet")
        editor.putInt("yas",18)
        editor.putFloat("boy",1.78f)
        editor.putBoolean("bekarMi",true)

        val arkadasListesi = HashSet<String>()
        arkadasListesi.add("Zeynep")
        arkadasListesi.add("Ece")
        arkadasListesi.add("Ali")

        editor.putStringSet("arkadasListesi",arkadasListesi)
        editor.commit() */

        binding.buttonGit.setOnClickListener {

            startActivity(Intent(this@MainActivity,ActivityB::class.java))

        }

    }
}