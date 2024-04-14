package com.fatihakbulut.retrofitkullanimi

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

// Bu interface içerisinde web servisler ile ilgili metotlar oluşturulacak ve daha sonra bunlar kullanılacak
interface KisilerDaoInterface {

    // Kişi silme işleminin yapılaması için web servise gerekli verinin aktarılmasını sağlayan kod
    @POST("kisiler/delete_kisiler.php") // Kullanıcak web servisi
    @FormUrlEncoded // Türkçe karakter desteği sağlıyor

    fun kisiSil(@Field("kisi_id") kisi_id:Int): retrofit2.Call<CRUDCevap> // kisi_id Field'ına kisi_id değeri verilecek ve web servis çalıştırıldıktan sonra CRUDCevap sonucu döndürülecek


    // Kişi silme işleminin yapılaması için web servise gerekli verinin aktarılmasını sağlayan kod
    @POST("kisiler/insert_kisiler.php")
    @FormUrlEncoded
    fun kisiEkle(@Field("kisi_ad") kisi_ad:String,
                 @Field("kisi_tel") kisi_tel:String): Call<CRUDCevap>


    // Kişi günelleme
    @POST("kisiler/update_kisiler.php")
    @FormUrlEncoded
    fun kisiGuncelle(@Field("kisi_id") kisi_id: Int,
                 @Field("kisi_ad") kisi_ad:String,
                 @Field("kisi_tel") kisi_tel:String): Call<CRUDCevap>

    @GET("kisiler/tum_kisiler.php")
    fun tumKisiler() : Call<KisilerCevap>

    @POST("kisiler/tum_kisiler_arama.php")
    @FormUrlEncoded
    fun kisiAra(@Field("kisi_ad") kisi_ad: String): Call<KisilerCevap>
}