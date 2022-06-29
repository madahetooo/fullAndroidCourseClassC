package com.apps.fullandroidcourseclassc.restuarantapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import com.apps.fullandroidcourseclassc.databinding.ActivityResturantMenuBinding

class ResturantMenuActivity : Fragment() {
    private lateinit var binding: ActivityResturantMenuBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityResturantMenuBinding.inflate(inflater,container,false)
        val view = binding.root
        binding.btnOrder.setOnClickListener {
            val checkedRadioButtonId = binding.rgMeals.checkedRadioButtonId
            val kindOfBurger = view?.findViewById<RadioButton>(checkedRadioButtonId)
            val cheese =  binding.chkCheese.isChecked // Cheese is Checked or not
            val onions =  binding.chkOnions.isChecked // Onions is Checked or not
            val salad =  binding.chkSalad.isChecked // Salad is Checked or not
            val totalOrder = "You Ordered burger with \n " + "${kindOfBurger?.text}"+
                    (if (cheese)"\n Cheese" else "")+
                    (if (onions)"\n Onions" else "")+
                    (if (salad)"\n Salad" else "")
            binding.tvTotalOrder.text = totalOrder
        }
        return view
    }
}