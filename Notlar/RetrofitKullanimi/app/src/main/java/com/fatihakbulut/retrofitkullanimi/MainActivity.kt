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
        kisiSil()

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
}