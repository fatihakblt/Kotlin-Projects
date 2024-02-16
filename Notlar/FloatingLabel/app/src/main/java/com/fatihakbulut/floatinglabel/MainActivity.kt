package com.fatihakbulut.floatinglabel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.fatihakbulut.floatinglabel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Toolbar bilgilerinin girilmesi
        binding.myToolbar.title ="Özel Toolbar Başlık"
        binding.myToolbar.subtitle = "Özel Toolbar AltBaşlık"
        binding.myToolbar.setLogo(R.drawable.resim)
        setSupportActionBar(binding.myToolbar)




        binding.buttonYap.setOnClickListener {
            // Alınan metinlerdeki boşlukları silmek için trim metodu kullanıldı.(whitespace boşlukların silinmesi)
            val ad = binding.editTextAd.text.toString().trim()
            val tel = binding.editTextTel.text.toString().trim()

            // ediTextlerin içinin boş olması durumunun kontrolü yapıldı
            // editTextler dolu ise devam eder dolu değilse buttonun çalışmasını durdurur.
            if(TextUtils.isEmpty(ad)){
                Toast.makeText(applicationContext,"Ad Boş", Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }
            if (TextUtils.isEmpty(tel)){
                Toast.makeText(applicationContext,"Tel Boş", Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }
            // Tel uzunluğunun minimum 6 haneli olması şartı getirildi.
            if (tel.length<6){
                Toast.makeText(applicationContext,"Tel en az 6 hane olmalıdır.",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            Toast.makeText(this@MainActivity,"$ad - $tel",Toast.LENGTH_SHORT).show()
        }


    }

    // Menu dosyasının toolbar ile bağlantısının kurulması
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return true
    }

    // Menu seçeneklerinin(itemlarının) seçilmesi ile yapılcak işlemlerin belirlenmesi
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_bilgi -> {
                Toast.makeText(applicationContext, "Bilgi Tıklandı", Toast.LENGTH_SHORT).show()
                return true
            }

            R.id.action_ayarlar -> {
                Toast.makeText(applicationContext, "Ayarlar Tıklandı", Toast.LENGTH_SHORT).show()
                return true
            }

            R.id.action_ekle -> {
                Toast.makeText(applicationContext, "Ekle Tıklandı", Toast.LENGTH_SHORT).show()
                return true
            }

            R.id.action_cikis -> {
                Toast.makeText(applicationContext, "Çıkış Tıklandı", Toast.LENGTH_SHORT).show()
                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }

    }

}