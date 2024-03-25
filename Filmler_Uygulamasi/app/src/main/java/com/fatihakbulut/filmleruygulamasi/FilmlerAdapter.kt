package com.fatihakbulut.filmleruygulamasi

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class FilmlerAdapter(private val mContext:Context,private val filmlerListe:List<Filmler>)
    : RecyclerView.Adapter<FilmlerAdapter.CardTasarimTutucu>() {
    // Card tasarimdaki tasarım nesnelerini MainActivity'e bağlama işlemi için iç sınıf oluşturuldu (inner class)
    inner class CardTasarimTutucu(tasarim: View): RecyclerView.ViewHolder(tasarim){
        var film_card: CardView
        var textViewFilm_ad: TextView
        var imageViewFilmResim:ImageView

        // Yukarıdaki tasarım nesnesi sayesinde iki görsel nesneye de erişmiş olduk.
        init {
            film_card = tasarim.findViewById(R.id.film_card)
            textViewFilm_ad = tasarim.findViewById(R.id.textViewFilmAd)
            imageViewFilmResim = tasarim.findViewById(R.id.imageViewResim)

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.film_card_tasarim,parent,false)
        return CardTasarimTutucu(tasarim)

    }

    override fun getItemCount(): Int {
        return filmlerListe.size
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val film = filmlerListe.get(position) // İndeks numaralarına göre sıralı olarak nesnelere erişme

        holder.textViewFilm_ad.text = film.film_ad
        holder.imageViewFilmResim.setImageResource(mContext.resources.getIdentifier(film.film_resim
            ,"drawable",mContext.packageName))

        // Card'a tıklanma özelliği verildi

        holder.film_card.setOnClickListener{
            // Datay activity'e geçiş yapılması ve verilerin aktarılması
            val intent = Intent(mContext,DetayActivity::class.java)
            intent.putExtra("filmNesne",film)
            mContext.startActivity(intent)

        }
    }
}