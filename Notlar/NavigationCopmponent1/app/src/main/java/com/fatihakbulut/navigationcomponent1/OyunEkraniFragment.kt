package com.fatihakbulut.navigationcomponent1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fatihakbulut.navigationcomponent1.databinding.FragmentAnasayfaBinding
import com.fatihakbulut.navigationcomponent1.databinding.FragmentOyunEkraniBinding

class OyunEkraniFragment : Fragment() {

    private lateinit var binding: FragmentOyunEkraniBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentOyunEkraniBinding.inflate(inflater, container, false)

        binding.buttonBitir.setOnClickListener {


        }

        return binding.root
    }

}