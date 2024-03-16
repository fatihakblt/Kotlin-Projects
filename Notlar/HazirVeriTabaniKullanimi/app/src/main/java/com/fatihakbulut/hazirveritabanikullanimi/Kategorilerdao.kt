package com.fatihakbulut.hazirveritabanikullanimi

import android.annotation.SuppressLint

class Kategorilerdao {

    @SuppressLint("Range")
    fun tumKategoriler(vt:VeritabaniYardimcisi) : ArrayList<Kategoriler>{
        val kategoriListe = ArrayList<Kategoriler>()

        val db = vt.writableDatabase

        val cursor = db.rawQuery("SELECT * FROM kategoriler",null) // Bu sorgu çalıştığında veriler teker teker cursor nesnesine aktarılacak

        while (cursor.moveToNext()){ // Satırlar bitene kadar çalışacak
            val kategori = Kategoriler(cursor.getInt(cursor.getColumnIndex("kategori_id"))
            ,cursor.getString(cursor.getColumnIndex("kategori_ad")))
            kategoriListe.add(kategori)
        }
        return kategoriListe
    }
}