package com.fatihakbulut.sqlite_kullanimi

import android.content.ContentValues

// Tablo  üzerindeki işlemleri temsil eden sınıf- Tablo isminin sonuna -dao eklenerek oluşturulur.

class Kisilerdao {

    // Insert - Veri ekleme
    fun kisiEkle(vt:VeritabaniYardimcisi, kisi_ad:String, kisi_tel:String, kisi_yas:Int, kisi_boy:Double){

        val db = vt.writableDatabase // Veritabanı yardımcısını kullanarak yazma işlemi yetkisi aldık.
        val values = ContentValues()

        values.put("kisi_ad", kisi_ad)
        values.put("kisi_tel", kisi_tel)
        values.put("kisi_yas", kisi_yas)
        values.put("kisi_boy", kisi_boy)


        db.insertOrThrow("kisiler", null, values) // Kayıt işleminin yapılması, hangi tablo, null, eklenecek değerler.
        db.close()  // Veritabanı bağlantısının kesilmesi

    }


}