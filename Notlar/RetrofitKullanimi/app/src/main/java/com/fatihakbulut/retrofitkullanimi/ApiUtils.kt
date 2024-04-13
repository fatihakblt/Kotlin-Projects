package com.fatihakbulut.retrofitkullanimi

class ApiUtils {

    // Bu sınıf ile base-url sınıfı verilerek interface'e erişilir ve böylece interface içerisindeki metotlara erişilmiş olur.
    companion object{
        val BASE_URL = "https://fatihakbulut.net/" // Ana  url adı

        fun getKisilerDaoInterface():KisilerDaoInterface{
            return RetrofitClient.getClient(BASE_URL).create(KisilerDaoInterface::class.java)
        }
    }
}