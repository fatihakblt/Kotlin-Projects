package com.fatihakbulut.notlaruygulamasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import com.fatihakbulut.notlaruygulamasi.databinding.ActivityDetayBinding
import com.google.android.material.snackbar.Snackbar

class DetayActivity : AppCompatActivity() {

    private lateinit var not: Notlar
    private lateinit var vt :VeritabaniYardimcisi
    private lateinit var binding : ActivityDetayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Toolbar işlemleri
        binding.toolbarNotDetay.title = "Not Detay"
        setSupportActionBar(binding.toolbarNotDetay)

        vt = VeritabaniYardimcisi(this)
        // Not nesnesiyle gelen bilgilerin alınması ve editText'lere aktarılması
        val not = intent.getSerializableExtra("nesne") as Notlar

        binding.editTextDers.setText(not.ders_adi)
        binding.editTextNot1.setText((not.not1).toString())
        binding.editTextNot2.setText((not.not2).toString())




    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.action_sil->{
                Snackbar.make(binding.toolbarNotDetay,"Silinsin mi?",Snackbar.LENGTH_SHORT)
                    .setAction("EVET"){

                        // Veritabanından silme işleminin yapılması
                        Notlardao().notSil(vt, not.not_id)
                        startActivity(Intent(this@DetayActivity,MainActivity::class.java))
                        finish()
                    }.show()
                return true
            }

            R.id.action_duzenle ->{

                // Veritabanındaki kayıtlı veriyi güncelleme

                // Edittext'e yazılan verilere ulaşıldı.
                val ders_adi = binding.editTextDers.text.toString().trim()
                val not1 = binding.editTextNot1.text.toString().trim()
                val not2 = binding.editTextNot2.text.toString().trim()

                // EditTextlerin boş olma durumu kontrolü yapıldı. Boş ise kayıt işlemi yapılmaz
                if (TextUtils.isEmpty(ders_adi)){
                    Snackbar.make(binding.toolbarNotDetay,"Ders adı giriniz",Snackbar.LENGTH_SHORT).show()
                    return false
                }
                if (TextUtils.isEmpty(not1)){
                    Snackbar.make(binding.toolbarNotDetay,"1. Notu giriniz",Snackbar.LENGTH_SHORT).show()
                    return false
                }
                if (TextUtils.isEmpty(not2)){
                    Snackbar.make(binding.toolbarNotDetay,"2. Notu giriniz",Snackbar.LENGTH_SHORT).show()
                    return false
                }

                Notlardao().notGuncelle(vt,not.not_id,ders_adi, not1.toInt(), not2.toInt())
                startActivity(Intent(this@DetayActivity,MainActivity::class.java))
                finish()
                return true
            }
            else -> return false
        }
        return super.onOptionsItemSelected(item)
    }
}
