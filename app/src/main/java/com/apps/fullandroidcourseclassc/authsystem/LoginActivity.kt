package com.apps.fullandroidcourseclassc.authsystem

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.apps.fullandroidcourseclassc.MotherOfTheApps
import com.apps.fullandroidcourseclassc.databinding.ActivityLoginBinding
import com.apps.fullandroidcourseclassc.ui.BaseActivity
import com.google.firebase.auth.FirebaseAuth

@Suppress("DEPRECATION")
class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    var pressTwiceToExit = false
    private lateinit var auth: FirebaseAuth
    @SuppressLint("CommitPrefEdits")
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null) {
            val intent = Intent(this, MotherOfTheApps::class.java)
            startActivity(intent)
            finish()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance() // initialize
        supportActionBar?.hide() //Hide toolbar

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
            val userName = binding.etUserName.text.toString()
            val password = binding.etPassword.text.toString()
            if (userName.isNotEmpty() && password.isNotEmpty()) {
                auth.signInWithEmailAndPassword(userName, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            val user = auth.currentUser
                            val intent = Intent(this, MotherOfTheApps::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(
                                baseContext, "Authentication failed.",
                                Toast.LENGTH_SHORT
                            ).show()
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
    override fun onBackPressed() {
        if (pressTwiceToExit) { // current value is TRUE
            finish() // when it is TRUE, Close the application
            super.onBackPressed()
        }
        pressTwiceToExit = true // Reassign to be TRUE
        Toast.makeText(this, "Press Again Quickly to Exit", Toast.LENGTH_SHORT).show()
        Handler().postDelayed({
            pressTwiceToExit = false // Return to our default value

        }, 3000)
    }
}
