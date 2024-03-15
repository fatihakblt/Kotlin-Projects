package com.fatihakbulut.hazirveritabanikullanimi

data class Filmler(
    var film_id:Int
    ,var film_ad:String
    ,var film_resim:String
    ,var kategori:Kategoriler // Foreign key olduğu için composition uygulandı, ilişkili sınıftan nesne oluşturuldu.
    ,var yonetmen:Yonetmenler)// Foreign key olduğu için composition uygulandı, ilişkili sınıftan nesne oluşturuldu.
{
}