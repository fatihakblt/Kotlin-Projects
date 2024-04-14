package com.fatihakbulut.retrofitkullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.fatihakbulut.retrofitkullanimi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Kisi silme işlemi
        //kisiSil()

        // Kisi ekleme işlemi
        //kisiEkle()

        // Kisi günceleme işlemi
        //kisiGucelle()

        // Kişi listeleme işlemi
        //tumKisiler()

        //Kisi arama işlemi
        kisiArama()
    }
    // Silme işlemi
    fun kisiSil(){
        // Silme işlemi
        val kdi = ApiUtils.getKisilerDaoInterface()
        kdi.kisiSil(3).enqueue(object : Callback<CRUDCevap>{

            // Gelen cevap
            override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>?) {

                if (response != null){
                    Log.e("Başarı",response.body().success.toString())
                    Log.e("Mesaj",response.body().message)

                }


            }

            // Hata alınırsa hata sonucunu döndüren metod
            override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {


            }
        })
    }

    fun kisiEkle(){
        // Ekleme işlemi
        val kdi = ApiUtils.getKisilerDaoInterface()
        kdi.kisiEkle("ahmet","999999").enqueue(object : Callback<CRUDCevap>{

            // Gelen cevap
            override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>?) {

                if (response != null){
                    Log.e("Başarı",response.body().success.toString())
                    Log.e("Mesaj",response.body().message)

                }


            }

            // Hata alınırsa hata sonucunu döndüren metod
            override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {


            }
        })
    }


    fun kisiGucelle(){
        // Ekleme işlemi
        val kdi = ApiUtils.getKisilerDaoInterface()
        kdi.kisiGuncelle(6,"yeni emir","999999").enqueue(object : Callback<CRUDCevap>{

            // Gelen cevap
            override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>?) {

                if (response != null){
                    Log.e("Başarı",response.body().success.toString())
                    Log.e("Mesaj",response.body().message)

                }


            }

            // Hata alınırsa hata sonucunu döndüren metod
            override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {


            }
        })
    }


    fun tumKisiler(){

        val kdi = ApiUtils.getKisilerDaoInterface()
        kdi.tumKisiler().enqueue(object : Callback<KisilerCevap>{

            override fun onResponse(call: Call<KisilerCevap>?, response: Response<KisilerCevap>?) {

                if(response != null){
                    val kisilerListe = response.body().kisiler

                    for (k in kisilerListe){
                        Log.e("*****","*****")
                        Log.e("Kisi id",(k.kisiId).toString())
                        Log.e("Kisi ad",(k.kisiAd))
                        Log.e("Kisi tel",(k.kisiTel))

                    }
                }

            }

            override fun onFailure(call: Call<KisilerCevap>?, t: Throwable?) {


            }
        })
    }

    fun kisiArama(){
        val kdi = ApiUtils.getKisilerDaoInterface()
        kdi.kisiAra("A").enqueue(object : Callback<KisilerCevap>{

            override fun onResponse(call: Call<KisilerCevap>?, response: Response<KisilerCevap>?) {

                if(response != null){
                    val kisilerListe = response.body().kisiler

                    for (k in kisilerListe){
                        Log.e("*****","*****")
                        Log.e("Kisi id",(k.kisiId).toString())
                        Log.e("Kisi ad",(k.kisiAd))
                        Log.e("Kisi tel",(k.kisiTel))

                    }
                }

            }

            override fun onFailure(call: Call<KisilerCevap>?, t: Throwable?) {


            }
        })
    }
}