package com.apps.fullandroidcourseclassc.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.apps.fullandroidcourseclassc.MainActivity
import com.apps.fullandroidcourseclassc.R
import com.apps.fullandroidcourseclassc.bullscarsapp.ui.BullsCarsActivity
import com.apps.fullandroidcourseclassc.calculatorapp.CalculatorFragment
import com.apps.fullandroidcourseclassc.databinding.ActivityHomeBinding
import com.apps.fullandroidcourseclassc.restuarantapp.ResturantMenuActivity
import com.apps.fullandroidcourseclassc.todolistapp.ui.TodoListActivity

@Suppress("DEPRECATION")
class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        setCurrentFragment(BullsCarsActivity())
        val todolistFragment = TodoListActivity()
        val restaurantFragment = ResturantMenuActivity()
        val counterFragment = MainActivity()
        val calculatorFragment = CalculatorFragment()
        val bullsCarFragment = BullsCarsActivity()

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.miTodoList -> setCurrentFragment(bullsCarFragment)
                R.id.miRestaurant -> setCurrentFragment(restaurantFragment)
                R.id.miCounter -> setCurrentFragment(counterFragment)
                R.id.miCalculator -> setCurrentFragment(calculatorFragment)
            }
            true
        }

    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit() // apply changes
        }

}