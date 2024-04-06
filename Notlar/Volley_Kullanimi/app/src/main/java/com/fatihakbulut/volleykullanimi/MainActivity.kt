package com.fatihakbulut.volleykullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.fatihakbulut.volleykullanimi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        kisiSil()
    }

    fun kisiSil(){
        // Web servisi ile iletişimin kurulması
        val url = "https://fatihakbulut.net/kisiler/delete_kisiler.php"

        val istek = object : StringRequest(Method.POST,url,Response.Listener { cevap ->
            Log.e("Silme İşlemi Cevap",cevap)
        },Response.ErrorListener { error ->error.printStackTrace()  }){

            override fun getParams() : MutableMap<String, String>? {

                val params = HashMap<String,String>()

                params["kisi_id"] = "1"

                return params
            }
        }

        // isteğin çalıştırılması
        Volley.newRequestQueue(this@MainActivity).add(istek)
    }
}