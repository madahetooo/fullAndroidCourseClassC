package com.apps.fullandroidcourseclassc.bullscarsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.apps.fullandroidcourseclassc.R
import com.apps.fullandroidcourseclassc.databinding.ActivityBullsCarsBinding

class BullsCarsActivity : Fragment() {
    lateinit var binding: ActivityBullsCarsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityBullsCarsBinding.inflate(inflater,container,false)
        val view = binding.root


        return view

    }
}