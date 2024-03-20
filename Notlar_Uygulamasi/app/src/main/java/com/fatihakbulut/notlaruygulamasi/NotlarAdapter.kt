package com.fatihakbulut.notlaruygulamasi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class NotlarAdapter(private val mContext:Context, private val notlarListe:List<Notlar>)
    :RecyclerView.Adapter<NotlarAdapter.CardTasarimTutucu>() {

    // Bu sınıfın NotlarAdapter!a bağlanması için :RecyclerView.Adapter<NotlarAdapter.CardTasarimTutucu>() yazılarak bağlanır
    inner class CardTasarimTutucu(tasarim:View) : RecyclerView.ViewHolder(tasarim) { // Bu iç sınıf ile card_tasarim dosyasındaki görsel nesnelere erişim sağlanır.

        var not_card :CardView  // Görsel nesnelerin tanımlanması
        var textViewDers:TextView
        var textViewNot1:TextView
        var textViewNot2:TextView

        // Görsel nesnelerin id'ler ile bağlanması
        init {
            not_card = tasarim.findViewById(R.id.not_card)
            textViewDers = tasarim.findViewById(R.id.textViewDers)
            textViewNot1 = tasarim.findViewById(R.id.textViewNot1)
            textViewNot2 = tasarim.findViewById(R.id.textViewNot2)
        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {

        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.card_tasarim,parent,false)
        return CardTasarimTutucu(tasarim)

    }

    override fun getItemCount(): Int {
        return notlarListe.size
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {

        val not = notlarListe.get(position) // Not nesenelerini index numaralarına erişim sağlanır.

        holder.textViewDers.text = not.ders_adi
        holder.textViewNot1.text = (not.not1).toString()
        holder.textViewNot2.text = (not.not2).toString()

        holder.not_card.setOnClickListener{

        }



    }
}