package com.fatihakbulut.navigationcomponent1

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.fatihakbulut.navigationcomponent1.databinding.FragmentAnasayfaBinding
import com.fatihakbulut.navigationcomponent1.databinding.FragmentOyunEkraniBinding

class OyunEkraniFragment : Fragment() {

    private lateinit var binding: FragmentOyunEkraniBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentOyunEkraniBinding.inflate(inflater, container, false)

        // AnasayfaFragmnet'tan gelen verileri alma

        val bundle: OyunEkraniFragmentArgs by navArgs()

        val gelenAd = bundle.ad
        val gelenYas = bundle.yas
        val gelenBoy = bundle.boy
        val gelenBekarMi = bundle.bekarMi
        val gelenNesne = bundle.nesne

        Log.e("Gelen Ad ", gelenAd)
        Log.e("Gelen Yas ", gelenYas.toString())
        Log.e("Gelen Boy ", gelenBoy.toString())
        Log.e("Gelen  Bekar Mı ", gelenBekarMi.toString())
        Log.e("Gelen  Kişi No ", gelenNesne.kisi_no.toString())
        Log.e("Gelen  Kişi Ad ", gelenNesne.kisi_ad)




        binding.buttonBitir.setOnClickListener {

            Navigation.findNavController(it).navigate(R.id.sonucEkraninaGecis) // Sonuç ekranına yönlendir.

        }

        return binding.root
    }

}