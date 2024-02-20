package com.fatihakbulut.tablayoutkullanimi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fatihakbulut.tablayoutkullanimi.databinding.FragmentIkinciLayoutBinding

class FragmentIkinci :Fragment(){

    private lateinit var binding: FragmentIkinciLayoutBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentIkinciLayoutBinding.inflate(inflater,container,false)
        return binding.root
    }
}