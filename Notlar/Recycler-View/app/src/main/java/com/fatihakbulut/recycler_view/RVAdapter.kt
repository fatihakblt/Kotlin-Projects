package com.fatihakbulut.recycler_view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import java.math.MathContext

class RVAdapter(private val mContext:Context, private val ulkelerDisaridanGelenListesi: List<Ulkeler>)
    :RecyclerView.Adapter<RVAdapter.CardViewTasarimNesneleriniTutucu>(){

    inner class CardViewTasarimNesneleriniTutucu(view: View):RecyclerView.ViewHolder(view){


        // Görsel nesnelere erişim
        var satirCardView: CardView
        var satirYazi : TextView
        var noktaResim : ImageView

        init {
            satirCardView = view.findViewById(R.id.satirCardView)
            satirYazi = view.findViewById(R.id.satirYazi)
            noktaResim = view.findViewById(R.id.noktaResim)


        }

    }

    // Yukarıdaki görsel nesnelere erişmek için tasarım nesnesi oluşturulur ve tasarım dosyası buraya aktarılır, card_tasarimi.xml
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardViewTasarimNesneleriniTutucu {

        val tasarim  = LayoutInflater.from(mContext).inflate(R.layout.card_tasarimi,parent,false) // Görsel tasarim ile yazılımsal tasarım birleştirildi, başka bir tasarım eklenmeycek denildi (false)
        return CardViewTasarimNesneleriniTutucu(tasarim)

    }


    // Kaç adet satır olacak?
    override fun getItemCount(): Int {

        return ulkelerDisaridanGelenListesi.size // ulkelerDisaridanGelenListesi veri sayısı kadar satır olacak.

    }

    // Görsel nesneler üzerinde işlemler yapılır.
    override fun onBindViewHolder(holder: CardViewTasarimNesneleriniTutucu, position: Int) {
        val ulke = ulkelerDisaridanGelenListesi[position]
        holder.satirYazi.text = ulke.ulkeAdi
        holder.satirCardView.setOnClickListener{
            Toast.makeText(mContext,"Seçtiğiniz Ülke : ${ulke.ulkeAdi}",Toast.LENGTH_SHORT).show()
        }

        holder.noktaResim.setOnClickListener{
            val popup = PopupMenu(mContext, holder.noktaResim) // Hangi context'te ve hangi öğe gösterecek
            popup.menuInflater.inflate(R.menu.popup_menu,popup.menu)
            popup.show()

            popup.setOnMenuItemClickListener {item->

                when(item.itemId){
                    R.id.action_sil ->{
                        Toast.makeText(mContext,"Sil : ${ulke.ulkeAdi}",Toast.LENGTH_SHORT).show()
                        true
                    }

                    R.id.action_duzenle ->{
                        Toast.makeText(mContext,"Düzenle : ${ulke.ulkeAdi}",Toast.LENGTH_SHORT).show()

                        true
                    }

                    else -> false
                }

            }
        }



    }

}