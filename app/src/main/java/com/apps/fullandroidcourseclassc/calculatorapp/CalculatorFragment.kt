package com.apps.fullandroidcourseclassc.calculatorapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.apps.fullandroidcourseclassc.R
import com.apps.fullandroidcourseclassc.databinding.FragmentCalculatorBinding

class CalculatorFragment : Fragment(R.layout.fragment_calculator) {
    lateinit var binding: FragmentCalculatorBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalculatorBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnAddition.setOnClickListener {

            if (binding.etFirstNumber.text.isNotEmpty() && binding.etSecondNumber.text.isNotEmpty()){

                val firstNumber = binding.etFirstNumber.text.toString().toInt()
                val secondNumber = binding.etSecondNumber.text.toString().toInt()
                val result = firstNumber + secondNumber
                binding.tvValueResult.text = result.toString()
            }else{
                Toast.makeText(activity,"Please fill the required data",Toast.LENGTH_SHORT).show()
            }

        }
        binding.btnMinus.setOnClickListener {
            val firstNumber = binding.etFirstNumber.text.toString().toInt()
            val secondNumber = binding.etSecondNumber.text.toString().toInt()
            val result = firstNumber - secondNumber
            binding.tvValueResult.text = result.toString()

        }
        binding.btnMultiplication.setOnClickListener {
            val firstNumber = binding.etFirstNumber.text.toString().toInt()
            val secondNumber = binding.etSecondNumber.text.toString().toInt()
            val result = firstNumber * secondNumber
            binding.tvValueResult.text = result.toString()
        }
        binding.btnDivision.setOnClickListener {
            val firstNumber = binding.etFirstNumber.text.toString().toDouble()
            val secondNumber = binding.etSecondNumber.text.toString().toDouble()
            val result = firstNumber / secondNumber
            binding.tvValueResult.text = result.toString()
        }
        binding.btnReset.setOnClickListener {
            binding.etFirstNumber.text.clear()
            binding.etSecondNumber.text.clear()
            binding.tvValueResult.setText("")
            Toast.makeText(activity,"Value Reseted",Toast.LENGTH_SHORT).show() // Show Toast
        }
        return view

    }
}