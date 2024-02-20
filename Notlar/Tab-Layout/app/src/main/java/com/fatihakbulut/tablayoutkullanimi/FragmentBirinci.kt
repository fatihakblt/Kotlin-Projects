package com.fatihakbulut.tablayoutkullanimi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fatihakbulut.tablayoutkullanimi.databinding.FragmentBirinciLayoutBinding

class FragmentBirinci : Fragment() {
    private lateinit var binding: FragmentBirinciLayoutBinding //View binding işleminin Fragment'e uygulanması 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentBirinciLayoutBinding.inflate(inflater,container,false)//2
        return binding.root // 3

    }
}