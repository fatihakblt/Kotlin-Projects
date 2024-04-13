package com.fatihakbulut.retrofitkullanimi

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

// Bu interface içerisinde web servisler ile ilgili metotlar oluşturulacak ve daha sonra bunlar kullanılacak
interface KisilerDaoInterface {

    @POST("kisiler/delete_kisiler.php") // Kullanıcak web servisi
    @FormUrlEncoded // Türkçe karakter desteği sağlıyor

    fun kisiSil(@Field("kisi_id") kisi_id:Int): retrofit2.Call<CRUDCevap> // kisi_id Field'ına kisi_id değeri verilecek ve web servis çalıştırıldıktan sonra CRUDCevap sonucu döndürülecek

}