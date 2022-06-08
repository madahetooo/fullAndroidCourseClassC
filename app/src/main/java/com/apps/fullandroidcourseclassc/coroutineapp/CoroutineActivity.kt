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

        GlobalScope.launch(Dispatchers.IO) {
            val result1 = async { doNetworkCall1() }
            val result2 = async { doNetworkCall2() }
            Log.d(TAG,"Result 1 is equal to : ${result1.await()}")
            Log.d(TAG,"Result 2 is equal to : ${result2.await()}")


//            var result1:String? = null
//            var result2:String? = null
//
//           launch(Dispatchers.IO) {
//                  result1 = doNetworkCall1() //Return String Result 1
//            }
//          launch(Dispatchers.IO) {
//                result2 = doNetworkCall2() //Return String Result 1
//            }
//
//            Log.d(TAG,"Result 1 is equal to : ${result1}")
//            Log.d(TAG,"Result 1 is equal to : ${result2}")
        }
    }
   suspend fun doNetworkCall1():String{
        delay(3000L)
        return "Network Call Result 1"
    }
    suspend fun doNetworkCall2():String{
        delay(9000L)
        return "Network Call Result 2"
    }
}