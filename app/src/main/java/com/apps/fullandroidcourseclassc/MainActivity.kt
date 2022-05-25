package com.apps.fullandroidcourseclassc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.apps.fullandroidcourseclassc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var count = 0
        binding.btnCount.setOnClickListener {
            count++
            binding.tvCounter.text = "Lets Count Together $count"
        }
    }
}