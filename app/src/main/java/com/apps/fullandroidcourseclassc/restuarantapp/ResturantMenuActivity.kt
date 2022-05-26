package com.apps.fullandroidcourseclassc.restuarantapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import com.apps.fullandroidcourseclassc.databinding.ActivityResturantMenuBinding

class ResturantMenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResturantMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResturantMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnOrder.setOnClickListener {
           val checkedRadioButtonId = binding.rgMeals.checkedRadioButtonId
            val kindOfBurger = findViewById<RadioButton>(checkedRadioButtonId)
           val cheese =  binding.chkCheese.isChecked // Cheese is Checked or not
           val onions =  binding.chkOnions.isChecked // Onions is Checked or not
           val salad =  binding.chkSalad.isChecked // Salad is Checked or not
            val totalOrder = "You Ordered burger with \n " + "${kindOfBurger.text}"+
                    (if (cheese)"\n Cheese" else "")+
                    (if (onions)"\n Onions" else "")+
                    (if (salad)"\n Salad" else "")
            binding.tvTotalOrder.text = totalOrder
        }
    }
}