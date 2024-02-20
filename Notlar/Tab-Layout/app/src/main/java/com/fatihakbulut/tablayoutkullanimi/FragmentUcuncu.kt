package com.fatihakbulut.tablayoutkullanimi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fatihakbulut.tablayoutkullanimi.databinding.FragmentIkinciLayoutBinding
import com.fatihakbulut.tablayoutkullanimi.databinding.FragmentUcuncuLayoutBinding

class FragmentUcuncu : Fragment() {
    private lateinit var binding: FragmentUcuncuLayoutBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentUcuncuLayoutBinding.inflate(inflater,container,false)
        return binding.root
    }
}