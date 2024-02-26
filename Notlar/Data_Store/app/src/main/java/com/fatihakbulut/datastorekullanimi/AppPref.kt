package com.fatihakbulut.datastorekullanimi

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

class AppPref(var context: Context) {
    val Context.ds : DataStore<Preferences> by preferencesDataStore("bilgiler")

    companion object{
        val AD_KEY = stringPreferencesKey("AD")
    }

    suspend fun kayitAd(ad:String){
        context.ds.edit {
            it[AD_KEY] = ad
        }
    }

    suspend fun  okuAd(): String{
        val p = context.ds.data.first()
        return p[AD_KEY] ?: "isim yok"
    }

    suspend fun silAd(ad:String){
        context.ds.edit {
            it.remove(AD_KEY)
        }
    }
}