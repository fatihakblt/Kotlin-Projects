package com.fatihakbulut.navigationcomponentkullanimi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fatihakbulut.navigationcomponentkullanimi.databinding.FragmentSonucEkraniBinding

class SonucEkraniFragment : Fragment() {
    private lateinit var binding: FragmentSonucEkraniBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = FragmentSonucEkraniBinding.inflate(inflater, container, false)

        return binding.root
    }
}