package com.fatihakbulut.notlaruygulamasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.fatihakbulut.notlaruygulamasi.databinding.ActivityDetayBinding
import com.google.android.material.snackbar.Snackbar

class DetayActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Toolbar işlemleri
        binding.toolbarNotDetay.title = "Not Detay"
        setSupportActionBar(binding.toolbarNotDetay)

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
                        startActivity(Intent(this@DetayActivity,MainActivity::class.java))
                        finish()
                    }.show()
                return true
            }

            R.id.action_duzenle ->{
                startActivity(Intent(this@DetayActivity,MainActivity::class.java))
                finish()
                return true
            }
            else -> return false
        }
        return super.onOptionsItemSelected(item)
    }
}
