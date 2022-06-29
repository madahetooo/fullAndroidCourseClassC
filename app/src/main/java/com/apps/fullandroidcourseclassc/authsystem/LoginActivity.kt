package com.apps.fullandroidcourseclassc.authsystem

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.apps.fullandroidcourseclassc.databinding.ActivityLoginBinding
import com.apps.fullandroidcourseclassc.ui.BaseActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
   lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        auth = FirebaseAuth.getInstance()

        val sharedPreferences = getSharedPreferences("loginDataFile", 0)
        val editor = sharedPreferences.edit()

        //READ THE DATA FROM SHAREDPREFRENCES
        val userNameFromSharedPreferences = sharedPreferences.getString("userNameKey", null)
        val passwordFromSharedPreferences = sharedPreferences.getString("passwordKey", null)
        val rememberMeFromSharedPreferences = sharedPreferences.getBoolean("isCheckedKey", false)


        // Setting the result on the view
        binding.etUserName.setText(userNameFromSharedPreferences)
        binding.etPassword.setText(passwordFromSharedPreferences)
        binding.chkRememberMe.isChecked = rememberMeFromSharedPreferences
        Toast.makeText(this,"Data Retrieved Successfully",Toast.LENGTH_SHORT).show()
        binding.chkRememberMe.setOnClickListener {
            val userName = binding.etUserName.text.toString() // Getting the username
            val password = binding.etPassword.text.toString() // Getting the password
            val isChecked = binding.chkRememberMe.isChecked //Getting the checkbox value

            // WRITE TO THE SHAREDPREFRENCES
            editor.apply {
                putString("userNameKey", userName)
                putString("passwordKey", password)
                putBoolean("isCheckedKey", isChecked)
                apply() // Applying changes
            }
            Toast.makeText(this,"Data Saved Successfully",Toast.LENGTH_SHORT).show()

        }
        binding.btnLogin.setOnClickListener {
            val userName = binding.etUserName.text.toString() // Getting the username
            val password = binding.etPassword.text.toString() // Getting the password

            //authentication
            if (userName.isNotEmpty() && password.isNotEmpty()){
                auth.signInWithEmailAndPassword(userName,password).addOnCompleteListener(this){
                    task ->
                    if (task.isSuccessful){
//                        val currentUser = auth.currentUser
                        val intent = Intent(this, BaseActivity::class.java)
                        startActivity(intent)
                        finish()
                    }else{
                        Toast.makeText(baseContext, "Authentication Failed ", Toast.LENGTH_SHORT).show()
                    }
                }

            }

        }
        binding.txRegister.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}