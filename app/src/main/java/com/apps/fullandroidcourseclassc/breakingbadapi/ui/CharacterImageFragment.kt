package com.apps.fullandroidcourseclassc.breakingbadapi.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.apps.fullandroidcourseclassc.R
import com.bumptech.glide.Glide

@Suppress("DEPRECATION")
class CharacterImageFragment : Fragment() {
    private val args:CharacterImageFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_charcter_image,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val ivCharacterImageSingle = requireActivity().findViewById<ImageView>(R.id.ivCharacterImage)
        Glide.with(requireContext()).load(args.imageUrl).centerCrop().into(ivCharacterImageSingle)

    }
}