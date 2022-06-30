package com.apps.fullandroidcourseclassc.authsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.apps.fullandroidcourseclassc.MotherOfTheApps
import com.apps.fullandroidcourseclassc.authsystem.model.ProfileInformation
import com.apps.fullandroidcourseclassc.ui.BaseActivity
import com.apps.fullandroidcourseclassc.databinding.ActivityRegistrationBinding
import com.apps.fullandroidcourseclassc.ui.HomeActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegistrationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrationBinding
    private lateinit var auth: FirebaseAuth
    private val profileInformationCollectionRef = Firebase.firestore.collection("ProfileInformation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance() // Initialize Firebase Auth
        supportActionBar?.hide()
        binding.btnRegister.setOnClickListener {
            val emailAddress = binding.etEmail.text.toString() // Getting EmailAddress
            val password = binding.etPasswordRegistration.text.toString() // Getting Password
            val profileInformation = getProfileInformation() // Holding the Data
          if (profileInformation != null){
              saveProfileInformation(profileInformation)
          }
            else{
              Toast.makeText(baseContext,"Please fill the required data",Toast.LENGTH_SHORT).show()
          }
            if (emailAddress.isNotEmpty() && password.isNotEmpty()){
                auth.createUserWithEmailAndPassword(emailAddress,password).addOnCompleteListener {task ->
                    if (task.isSuccessful){
                        val user  = auth.currentUser
                        val intent = Intent(this, MotherOfTheApps::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
            }

        }
        binding.txLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun getProfileInformation() : ProfileInformation{
        val fullName = binding.etFullName.text.toString() // Getting FullName
        val userName = binding.etUserNameRegistration.text.toString() // Getting UserName
        val emailAddress = binding.etEmail.text.toString() // Getting EmailAddress
        val phoneNumber = binding.etPhoneNumber.text.toString() // Getting PhoneNumber
        val password = binding.etPasswordRegistration.text.toString() // Getting Password
        return ProfileInformation(fullName,userName,emailAddress,phoneNumber,password)
    }
    private fun saveProfileInformation (profileInformation :ProfileInformation){

        CoroutineScope(Dispatchers.IO).launch {
            try {
                profileInformationCollectionRef.add(profileInformation) // Add data to Firestore database
                withContext(Dispatchers.Main){
                    Toast.makeText(this@RegistrationActivity,"Data Saved Successfully",Toast.LENGTH_SHORT).show()
                }
            }catch (e:Exception){
                withContext(Dispatchers.Main){
                    Toast.makeText(this@RegistrationActivity,e.message,Toast.LENGTH_LONG).show()
                }

            }
        }
    }

}