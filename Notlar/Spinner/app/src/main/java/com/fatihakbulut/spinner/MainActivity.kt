package com.fatihakbulut.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.fatihakbulut.spinner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val ulkeler = ArrayList<String>()
    private lateinit var veriAdaptoru: ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        ulkeler.add("Türkiye")
        ulkeler.add("İtalya")
        ulkeler.add("Japonya")
        ulkeler.add("Çin")
        ulkeler.add("Rusya")
        ulkeler.add("İngiltere")

        // Birinci değişken hangi context' de çalışıldığı,
        // ikinci değişken hazır bir spinner tasarımı,
        // üçüncü değişken metinin yeri yani text'in yeri
        // son değişken veri seti
        veriAdaptoru = ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1,android.R.id.text1,ulkeler)

        // Spinner veriAdaptoru ile bağladık.
        binding.spinner.adapter = veriAdaptoru


        // Spinnerdaki bir öğe seçildiğince gerçekleşecek eylemler
        binding.spinner.onItemSelectedListener = object  : AdapterView.OnItemSelectedListener{

            // Bir şey seçildiğinde
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                // Position -> verinin indeks numarası
                Toast.makeText(applicationContext,"Seçilen Ülke: ${ulkeler[position]}", Toast.LENGTH_SHORT).show()
            }

            // Bir şey seçilmedğinde
            override fun onNothingSelected(parent: AdapterView<*>?) {



            }
        }

        binding.buttonGoster.setOnClickListener {
            // binding.spinner.selectedItemPosition spinner'da en son seçilen verinin indeksini alabiliriz.

            Toast.makeText(applicationContext,"Seçilen Ülke: ${ulkeler[binding.spinner.selectedItemPosition]}", Toast.LENGTH_SHORT).show()


        }

    }
}