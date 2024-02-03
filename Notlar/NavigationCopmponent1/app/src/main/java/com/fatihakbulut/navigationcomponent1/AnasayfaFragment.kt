package com.fatihakbulut.navigationcomponent1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.fatihakbulut.navigationcomponent1.databinding.FragmentAnasayfaBinding

class AnasayfaFragment : Fragment() {

    private lateinit var binding: FragmentAnasayfaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        binding.buttonBasla.setOnClickListener {

            // Nesne sınıfından veri transferi
            // Kisiler adında bir data class oluşturuldu (Veri transferi olacağı için data class oldu ve Serializable sınıfından extendd edildi!!!)
            // oyunEkraniFragment'a Arguments attribute'una alınacak nesnenin ismi nesne olarak yazıldı.
            // Nesnenin veri tipi Custom Serializable olarak seçildi
            // Oluşturulmuş sınıf seçildi. Ve eklendi.

            val kisi  = Kisiler(1,"Mehmet")



            // oyunEkraniFragment'a Arguments attribute'una alınacak verilerin isimleri, veri tipleri, varsayılan değerleri eklendi.

            val gecis = AnasayfaFragmentDirections.oyunEkraninaGecis(kisi,"Ahmet",18,1.78f,true)// Gönderilecek veri Direcitons eklentisi ile gönderilir ve hangi geçiş ile yapılacağı belirtilir.


            // Veri aktarmadan geçiş için navigate(R.id.oyunEkraninaGecis) kullanıldı.

            Navigation.findNavController(it).navigate(gecis) // Oyun ekranına yönlendirme !!veri aktarımı yapılarak.
        }

        return  binding.root
    }

}