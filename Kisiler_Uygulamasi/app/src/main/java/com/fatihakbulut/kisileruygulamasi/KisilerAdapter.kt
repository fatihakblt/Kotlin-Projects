package com.fatihakbulut.kisileruygulamasi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class KisilerAdapter(private val mContext:Context,private val kisilerListe:List<Kisiler>) : RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu>(){

    // Card tasarımını tanımladık
    inner class CardTasarimTutucu(tasarim:View) : RecyclerView.ViewHolder(tasarim){
        var textViewKisiBilgi:TextView
        var imageViewNokta:ImageView

        init {
            textViewKisiBilgi = tasarim.findViewById(R.id.textViewKisiBilgi)
            imageViewNokta = tasarim.findViewById(R.id.imageViewNokta)
        }
    }

    // Tasarımı Adapter sınıfına aktarmamızı sağlayan fonksiyon
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.kisi_card_tasarim,parent,false)
        return CardTasarimTutucu(tasarim)
    }

    override fun getItemCount(): Int {
        return kisilerListe.size
    }

    // Görsel nesneler üzerinde organizasyon işlemi yapılan fonksiyon
    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {

        val kisi = kisilerListe.get(position) // Position inedex nesnelerin index numaralarını verir ve bununla nesnelere ulaşmamız sağlanır.

        holder.textViewKisiBilgi.text = "${kisi.kisi_ad} - ${kisi.kisi_tel}"

        holder.imageViewNokta.setOnClickListener {

            val popopMenu  = PopupMenu(mContext,holder.imageViewNokta)
            popopMenu.menuInflater.inflate(R.menu.popup_menu,popopMenu.menu)
            popopMenu.setOnMenuItemClickListener {menuItem ->
                when(menuItem.itemId){
                    R.id.action_sil ->{
                        Snackbar.make(holder.imageViewNokta,"${kisi.kisi_ad} silinsin mi?",Snackbar.LENGTH_SHORT)
                            .setAction("EVET"){

                            }.show()
                        true
                    }

                    R.id.action_guncelle ->{

                        true
                    }
                    else -> false
                }

            }

            popopMenu.show()
        }
    }
}