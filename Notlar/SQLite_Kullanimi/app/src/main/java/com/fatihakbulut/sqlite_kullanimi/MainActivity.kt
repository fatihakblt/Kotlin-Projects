package com.fatihakbulut.sqlite_kullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.fatihakbulut.sqlite_kullanimi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val vt = VeritabaniYardimcisi(this)


        // Veri kaydı işlemi
        //Kisilerdao().kisiEkle(vt,"Mehmet", "45345435", 16,1.60) // Kisilerdao sınıfından sanal nesne oluşturulup fonksiyona erişildi.
        //Kisilerdao().kisiEkle(vt,"Zeynep", "64534534", 12,1.55) // Kisilerdao sınıfından sanal nesne oluşturulup fonksiyona erişildi.
        //Kisilerdao().kisiEkle(vt,"Ali", "74545676", 9,1.60) // Kisilerdao sınıfından sanal nesne oluşturulup fonksiyona erişildi.



        // Veri silme
        //Kisilerdao().kisiSil(vt,3) // kisi_no'su 3 olan kişiyi siler.


        // Veri güncelleme
        //Kisilerdao().kisiGuncelle(vt,3,"Yeni Mehmet","111",100, 1.22)


        // Veri arama işlemi

        val kisiListe = Kisilerdao().arama(vt,"e") // kisi_ad'ında "e" harfi içeren kişileri listeler
        for (k in kisiListe){
            Log.e("Kişi no",(k.kisi_no).toString())
            Log.e("Kişi ad",(k.kisi_ad))
            Log.e("Kişi tel",(k.kisi_tel))
            Log.e("Kişi boy",(k.kisi_boy).toString())}



            /*
                    // Veri okuma işlemi
                    val kisiListe = Kisilerdao().tumKisiler(vt) // Veri tabanından alınan nesnelerin verilerine bu arrayList ile satır satır ulaşılması.

                    for (k in kisiListe){
                        Log.e("Kişi no",(k.kisi_no).toString())
                        Log.e("Kişi ad",(k.kisi_ad))
                        Log.e("Kişi tel",(k.kisi_tel))
                        Log.e("Kişi boy",(k.kisi_boy).toString())

                    }*/



    }


}