package com.fatihakbulut.volleykullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.fatihakbulut.volleykullanimi.databinding.ActivityMainBinding
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //kisiSil()

        //kisiEkle()

        //kisiGuncelle()

        //tumKisiler()

        aramaYap()
    }

    fun kisiSil(){
        // Web servisi ile iletişimin kurulması
        val url = "https://fatihakbulut.net/kisiler/delete_kisiler.php"

        val istek = object : StringRequest(Method.POST,url,Response.Listener { cevap ->
            Log.e("Silme İşlemi Cevap",cevap)
        },Response.ErrorListener { error ->error.printStackTrace()  }){

            override fun getParams() : MutableMap<String, String> {

                val params = HashMap<String,String>()

                params["kisi_id"] = "1"

                return params
            }
        }

        // isteğin çalıştırılması
        Volley.newRequestQueue(this@MainActivity).add(istek)
    }

    fun kisiEkle(){
        val url =  "https://fatihakbulut.net/kisiler/insert_kisiler.php"
        val istek = object : StringRequest(Method.POST,url,Response.Listener { cevap ->
            Log.e("Ekleme İşlemi Cevap",cevap)
        },Response.ErrorListener { error ->error.printStackTrace()  }){

            override fun getParams() : MutableMap<String, String> {

                val params = HashMap<String,String>()

                params["kisi_ad"] = "testad1"
                params["kisi_tel"] = "testtel1"
                return params
            }
        }
        // isteğin çalıştırılması
        Volley.newRequestQueue(this@MainActivity).add(istek)

    }


    fun kisiGuncelle(){
        val url =  "https://fatihakbulut.net/kisiler/update_kisiler.php"
        val istek = object : StringRequest(Method.POST,url,Response.Listener { cevap ->
            Log.e("Güncelleme İşlemi Cevap",cevap)
        },Response.ErrorListener { error ->error.printStackTrace()  }){

            override fun getParams() : MutableMap<String, String> {

                val params = HashMap<String,String>()

                params["kisi_id"] = "9"
                params["kisi_ad"] = "testad1Guncel"
                params["kisi_tel"] = "testtel1Guncel"
                return params
            }
        }
        // isteğin çalıştırılması
        Volley.newRequestQueue(this@MainActivity).add(istek)

    }

    fun tumKisiler(){
        val url =  "https://fatihakbulut.net/kisiler/tum_kisiler.php"
        val istek = StringRequest(Request.Method.GET,url,Response.Listener { cevap ->

            Log.e("Veri Okuma Cevap",cevap)

            try {
                val jsonObject = JSONObject(cevap) // Cevap json formatına dönüştürüldü.
                val kisilerListe = jsonObject.getJSONArray("kisiler") // Cevapdaki arrayin adı kisiler

                // Array içindeki öeğelere erişme
                for(i in  0 until kisilerListe.length()){
                    val k = kisilerListe.getJSONObject(i)

                    val kisi_id = k.getInt("kisi_id")
                    val kisi_ad = k.getString("kisi_ad")
                    val kisi_tel = k.getString("kisi_tel")

                    Log.e("Kisi id",kisi_id.toString())
                    Log.e("Kisi ad",kisi_ad)
                    Log.e("Kisi tel",kisi_tel)
                    Log.e("******","******")



                }


            }catch (e:JSONException){
                e.printStackTrace()
            }

        },Response.ErrorListener { error ->error.printStackTrace()  })

        // isteğin çalıştırılması
        Volley.newRequestQueue(this@MainActivity).add(istek)

    }


    fun aramaYap(){
        // Web servisi ile iletişimin kurulması
        val url = "https://fatihakbulut.net/kisiler/tum_kisiler_arama.php"

        val istek = object : StringRequest(Method.POST,url,Response.Listener { cevap ->
            Log.e("Arama Cevap",cevap)
        },Response.ErrorListener { error ->error.printStackTrace()  }){

            override fun getParams() : MutableMap<String, String> {

                val params = HashMap<String,String>()

                params["kisi_ad"] = "A"

                return params
            }
        }

        // isteğin çalıştırılması
        Volley.newRequestQueue(this@MainActivity).add(istek)
    }




}