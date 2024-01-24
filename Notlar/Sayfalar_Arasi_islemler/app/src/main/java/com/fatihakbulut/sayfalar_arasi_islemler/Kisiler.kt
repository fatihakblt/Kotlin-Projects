package com.fatihakbulut.sayfalar_arasi_islemler

import java.io.Serializable
// Veri taşıma işlemini büyük veriler ile yapmak için data class oluştururuz.
// Bu sınıftan oluşturulan nesneyi karşı tarafa taşımak istiyorsak Serializable interface'sini alması gereklidir
data class Kisiler(var tcno : Int, var isim : String, var boy : Double) : Serializable {

}