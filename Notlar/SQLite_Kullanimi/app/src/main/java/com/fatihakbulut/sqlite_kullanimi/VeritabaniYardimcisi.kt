package com.fatihakbulut.sqlite_kullanimi

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class VeritabaniYardimcisi(context:Context) : SQLiteOpenHelper(context, "rehber", null, 1) {

    // Veritabanında tabloların oluşturulduğu yer.
    override fun onCreate(db: SQLiteDatabase?) {

        db?.execSQL("CREATE TABLE kisiler (kisi_no INTEGER PRIMARY KEY AUTOINCREMENT" +
                ", kisi_ad TEXT, kisi_tel TEXT, kisi_yas INTEGER, kisi_boy DOUBLE );")


    }

    // Veritabanında bir sorun olduğunda ne olacağını yazdığımız yer
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        db?.execSQL("DROP TABLE IF EXISTS kisiler") // Tablo silinir
        onCreate(db) // Tekrar oluşturulur.

    }
}