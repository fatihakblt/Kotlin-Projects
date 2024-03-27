package com.fatihakbulut.kisileruygulamasi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class KisilerAdapter(private val mContext:Context
,private var kisilerListe:List<Kisiler>
,private val vt:VeritabaniYardimcisi)
    : RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu>(){

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
                                // Silme işleminin gerçekleştirilmesi
                                Kisilerdao().kisiSil(vt,kisi.kisi_id)
                                // Listenin güncel halinin tekrar alınması
                                kisilerListe = Kisilerdao().tumKisiler(vt)
                                // Silme işlemindem sonra arayüzün yenilenmesi
                                notifyDataSetChanged()
                            }.show()
                        true
                    }

                    R.id.action_guncelle ->{
                        // Verilerin editText'e aktarılması
                        alertGoster(kisi)

                        true
                    }
                    else -> false
                }

            }

            popopMenu.show()
        }
    }
    fun alertGoster(kisi:Kisiler){
        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.alert_tasarim,null)
        val editTextAd = tasarim.findViewById(R.id.editTextAd) as EditText
        val editTextTel = tasarim.findViewById(R.id.editTextTel) as EditText

        editTextAd.setText(kisi.kisi_ad)
        editTextTel.setText(kisi.kisi_tel)

        val ad = AlertDialog.Builder(mContext)

        ad.setTitle("Kişi Güncelle")
        ad.setView(tasarim)

        ad.setPositiveButton("Güncelle"){dialogInterface, i ->

            val kisi_ad = editTextAd.text.toString().trim()
            val kisi_tel = editTextTel.text.toString().trim()

            // Guncelleme işleminin yapılması
            Kisilerdao().kisiGuncelle(vt,kisi.kisi_id,kisi_ad,kisi_tel)
            // Listenin güncel halinin tekrar alınması
            kisilerListe = Kisilerdao().tumKisiler(vt)
            // Güncelleme işleminden sonra arayüzün yenilenmesi
            notifyDataSetChanged()
            Toast.makeText(mContext,"$kisi_ad - $kisi_tel", Toast.LENGTH_SHORT).show()

        }

        ad.setNegativeButton("İptal"){dialogInterface, i ->
        }
        ad.create().show()
    }
}