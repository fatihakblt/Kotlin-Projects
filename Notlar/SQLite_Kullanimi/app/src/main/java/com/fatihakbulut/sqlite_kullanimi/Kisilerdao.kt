package com.fatihakbulut.sqlite_kullanimi

import android.annotation.SuppressLint
import android.content.ContentValues

// Tablo  üzerindeki işlemleri temsil eden sınıf- Tablo isminin sonuna -dao eklenerek oluşturulur.

class Kisilerdao {

    // Insert - Veri ekleme
    fun kisiEkle(
        vt: VeritabaniYardimcisi,
        kisi_ad: String,
        kisi_tel: String,
        kisi_yas: Int,
        kisi_boy: Double
    ) {

        val db =
            vt.writableDatabase // Veritabanı yardımcısını kullanarak yazma işlemi yetkisi aldık.
        val values = ContentValues()

        values.put("kisi_ad", kisi_ad)
        values.put("kisi_tel", kisi_tel)
        values.put("kisi_yas", kisi_yas)
        values.put("kisi_boy", kisi_boy)


        db.insertOrThrow(
            "kisiler",
            null,
            values
        ) // Kayıt işleminin yapılması, hangi tablo, null, eklenecek değerler.
        db.close()  // Veritabanı bağlantısının kesilmesi

    }

    // Veri silme işlemi

    fun kisiSil(vt: VeritabaniYardimcisi, kisi_no: Int) {
        val db = vt.writableDatabase
        db.delete("kisiler", "kisi_no=?", arrayOf(kisi_no.toString()))

        db.close()
    }


    // Veri güncelleme işlemi
    fun kisiGuncelle(
        vt: VeritabaniYardimcisi,
        kisi_no: Int,
        kisi_ad: String,
        kisi_tel: String,
        kisi_yas: Int,
        kisi_boy: Double
    ) {

        val db =
            vt.writableDatabase // Veritabanı yardımcısını kullanarak yazma işlemi yetkisi aldık.
        val values = ContentValues()

        values.put("kisi_ad", kisi_ad)
        values.put("kisi_tel", kisi_tel)
        values.put("kisi_yas", kisi_yas)
        values.put("kisi_boy", kisi_boy)


        db.update("kisiler", values, "kisi_no=?", arrayOf(kisi_no.toString()))
        db.close()  // Veritabanı bağlantısının kesilmesi

    }


    // Select - Veri okuma
    @SuppressLint("Range")
    fun tumKisiler(vt: VeritabaniYardimcisi): ArrayList<Kisiler> {

        val kisilerArrayList = ArrayList<Kisiler>()
        val db =
            vt.readableDatabase // Veritabanı yardımcısını kullanarak yazma işlemi yetkisi aldık.

        val cursor = db.rawQuery("SELECT * FROM kisiler", null)

        while (cursor.moveToNext()) { // Satırları okumka için kullandığımız metod

            val kisi = Kisiler(
                cursor.getInt(cursor.getColumnIndex("kisi_no")),
                cursor.getString(cursor.getColumnIndex("kisi_ad")),
                cursor.getString(cursor.getColumnIndex("kisi_tel")),
                cursor.getInt(cursor.getColumnIndex("kisi_yas")),
                cursor.getDouble(cursor.getColumnIndex("kisi_boy"))
            )

            kisilerArrayList.add(kisi)


        }
        return kisilerArrayList
    }

    @SuppressLint("Range")
    fun arama(vt: VeritabaniYardimcisi, keyWord: String): ArrayList<Kisiler> {

        val kisilerArrayList = ArrayList<Kisiler>()
        val db =
            vt.readableDatabase // Veritabanı yardımcısını kullanarak yazma işlemi yetkisi aldık.

        val cursor = db.rawQuery("SELECT * FROM kisiler WHERE kisi_ad like '%$keyWord%'", null)

        while (cursor.moveToNext()) { // Satırları okumka için kullandığımız metod

            val kisi = Kisiler(
                cursor.getInt(cursor.getColumnIndex("kisi_no")),
                cursor.getString(cursor.getColumnIndex("kisi_ad")),
                cursor.getString(cursor.getColumnIndex("kisi_tel")),
                cursor.getInt(cursor.getColumnIndex("kisi_yas")),
                cursor.getDouble(cursor.getColumnIndex("kisi_boy"))
            )

            kisilerArrayList.add(kisi)

        }
        return kisilerArrayList
    }

    // Rastgele ve sınırlı veri almma
    @SuppressLint("Range")
    fun rastgeleGetir(vt: VeritabaniYardimcisi): ArrayList<Kisiler> {

        val kisilerArrayList = ArrayList<Kisiler>()
        val db =
            vt.readableDatabase // Veritabanı yardımcısını kullanarak yazma işlemi yetkisi aldık.

        val cursor = db.rawQuery("SELECT * FROM kisiler ORDER BY RANDOM() LIMIT 2", null) // Rastgele 2 veri okur

        while (cursor.moveToNext()) { // Satırları okumak için kullandığımız metod

            val kisi = Kisiler(
                cursor.getInt(cursor.getColumnIndex("kisi_no")),
                cursor.getString(cursor.getColumnIndex("kisi_ad")),
                cursor.getString(cursor.getColumnIndex("kisi_tel")),
                cursor.getInt(cursor.getColumnIndex("kisi_yas")),
                cursor.getDouble(cursor.getColumnIndex("kisi_boy"))
            )

            kisilerArrayList.add(kisi)


        }
        return kisilerArrayList
    }

    // Kayıt kontrol
    @SuppressLint("Range")

    fun kayitKontrol(vt:VeritabaniYardimcisi,kisi_ad: String): Int{

        var sonuc = 0

        val db = vt.writableDatabase
        val cursor = db.rawQuery("SELECT count(*) AS sonuc FROM kisiler WHERE kisi_ad='$kisi_ad'", null) // Rastgele 2 veri okur


        while (cursor.moveToNext()){ // Kaç adet cursor nesnesi oluşursa o kadar çalış.

            sonuc = cursor.getInt(cursor.getColumnIndex("sonuc"))

        }
        return  sonuc

    }

    // Bir tane kayıt alma
    @SuppressLint("Range")
    fun kisiGetir(vt: VeritabaniYardimcisi,kisi_no: Int): Kisiler? {

        var gelenKisi : Kisiler? = null

        val db =
            vt.writableDatabase // Veritabanı yardımcısını kullanarak yazma işlemi yetkisi aldık.

        val cursor = db.rawQuery("SELECT * FROM kisiler WHERE kisi_no=$kisi_no",null)

        while (cursor.moveToNext()) { // Satırları okumka için kullandığımız metod
            gelenKisi = Kisiler(
                cursor.getInt(cursor.getColumnIndex("kisi_no")),
                cursor.getString(cursor.getColumnIndex("kisi_ad")),
                cursor.getString(cursor.getColumnIndex("kisi_tel")),
                cursor.getInt(cursor.getColumnIndex("kisi_yas")),
                cursor.getDouble(cursor.getColumnIndex("kisi_boy"))
            )

        }
        return gelenKisi
    }


}