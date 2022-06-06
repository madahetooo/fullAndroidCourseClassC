package com.apps.fullandroidcourseclassc.coroutineapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.apps.fullandroidcourseclassc.databinding.ActivityCoroutineBinding
import kotlinx.coroutines.*

class CoroutineActivity : AppCompatActivity() {
    val TAG = "CoroutineActivity"
    lateinit var binding: ActivityCoroutineBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoroutineBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val job1 = GlobalScope.launch(Dispatchers.IO) {
            repeat(6) {
                Log.d(TAG, "Coroutine is Working")
                delay(1000L)
            }
        }
        runBlocking {
            delay(3000L)
            job1.cancel()
            Log.d(TAG, "Main is Working Now")
        }
    }
}