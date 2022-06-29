package com.apps.fullandroidcourseclassc.authsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.apps.fullandroidcourseclassc.ui.BaseActivity
import com.apps.fullandroidcourseclassc.databinding.ActivityRegistrationBinding
import com.apps.fullandroidcourseclassc.ui.HomeActivity
import com.google.firebase.auth.FirebaseAuth
const val TAG = "Registration"
class RegistrationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrationBinding
    lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        auth = FirebaseAuth.getInstance()

        binding.btnRegister.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPasswordRegistration.text.toString()
            if(email.isNotEmpty() && password.isNotEmpty()){
                auth.createUserWithEmailAndPassword(email,password).addOnSuccessListener {
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    finish()
                    Log.d(TAG,"Authentication Succeed")
                    Toast.makeText(this,"Done",Toast.LENGTH_SHORT).show()
                }.addOnFailureListener {
                    Log.d(TAG,"Authentication Failed")
                    Toast.makeText(this,"Fail",Toast.LENGTH_SHORT).show()

                }
            }

        }
        binding.txLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

//etEmailAddressLayout, etPasswordRegistrationLayout