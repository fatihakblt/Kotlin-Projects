package com.fatihakbulut.sqlite_kullanimi
// Veritabaındaki tablomuzu temsil eden sınıf
// Veritabanındaki her bir tablo için bir sınıf oluşturulmalı.
data class Kisiler(var kisi_no : Int,
              var kisi_ad: String,
              var kisi_tel:String,
              var kisi_yas:Int,
              var kisi_boy:Double) {
}