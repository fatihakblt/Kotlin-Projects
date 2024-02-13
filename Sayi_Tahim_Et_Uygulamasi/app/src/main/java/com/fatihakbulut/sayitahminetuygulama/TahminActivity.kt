package com.fatihakbulut.sayitahminetuygulama

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.fatihakbulut.sayitahminetuygulama.databinding.ActivityTahminBinding
import kotlin.random.Random

class TahminActivity : AppCompatActivity() {
    // Rastgele sayı üretme ve sayaç global değişkenleri
    private var rastgeleSayi = 0
    private var sayac = 5


    private lateinit var binding: ActivityTahminBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTahminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rastgeleSayi = Random.nextInt(26) // 0 ile 100 arası rastgele sayı üretimi

        Log.e("Rastgele Sayı", rastgeleSayi.toString()) // Tahmin edilen sayının testi için konsola bilgi verilmesi


        binding.buttonTahmin.setOnClickListener {




            sayac-=1 // Kalan hakkın azaltılması
            val tahmin = binding.editTextTahmin.text.toString().toInt() // edittextteki veri editable veri türünde olduğu için ilk başta string'e dönüştürüp sonra Int veri tipine dönüştürdük.

            if (sayac == 0 ){
                val intent = Intent(this@TahminActivity,SonucActivity:: class.java)
                intent.putExtra("sonuc", false) // Cevabı doğru bilemediği bilgisini sonraki sayfaya aktarma -kaybetti.
                intent.putExtra("sayi", rastgeleSayi)
                finish()
                startActivity(intent)

            }
            if (tahmin == rastgeleSayi){

                val intent = Intent(this@TahminActivity,SonucActivity:: class.java)
                intent.putExtra("sonuc", true) // Cevabı doğru bildiği bilgisini sonraki sayfaya aktarma -kazandı.
                intent.putExtra("sayi",rastgeleSayi)
                finish()
                startActivity(intent)
            }
            else if(tahmin > rastgeleSayi){
                binding.textViewYardim.text = "Azalt"
                binding.textViewKalanHak.text = "Kalan Hak : $sayac"

            }

            else if (tahmin < rastgeleSayi){
                binding.textViewYardim.text = "Arttır"
                binding.textViewKalanHak.text = "Kalan Hak : $sayac"


            }


            binding.editTextTahmin.setText("") // Her seferinde edittextin içini temizlemek için kullandık

        }
    }
}