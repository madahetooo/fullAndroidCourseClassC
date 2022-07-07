package com.apps.fullandroidcourseclassc

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.apps.fullandroidcourseclassc.authsystem.LoginActivity
import com.apps.fullandroidcourseclassc.breakingbadapi.model.BreakingBadCharacter
import com.apps.fullandroidcourseclassc.breakingbadapi.ui.BreakingBadActivity
import com.apps.fullandroidcourseclassc.bullscarsapp.ui.BullsCarsActivity
import com.apps.fullandroidcourseclassc.databinding.MotherOfTheAppsBinding
import com.apps.fullandroidcourseclassc.firebasestorageapp.ui.ClothesApp
import com.apps.fullandroidcourseclassc.shoppingitemlistapp.ui.ShoppingActivity
import com.apps.fullandroidcourseclassc.todolistapiapp.ui.TodoListApiActivity
import com.apps.fullandroidcourseclassc.ui.BaseActivity
import com.apps.fullandroidcourseclassc.ui.HomeActivity
import com.google.firebase.auth.FirebaseAuth

class MotherOfTheApps : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: MotherOfTheAppsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()
        binding = MotherOfTheAppsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnTodolistAndCalculator.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
        binding.btnPushNotificationApp.setOnClickListener {
            val intent = Intent(this, BaseActivity::class.java)
            startActivity(intent)
        }
        binding.btnBreakingBadApp.setOnClickListener {
            val intent = Intent(this, BreakingBadActivity::class.java)
            startActivity(intent)
        }
        binding.btnClothesApp.setOnClickListener {
            val intent = Intent(this, ClothesApp::class.java)
            startActivity(intent)
        }
        binding.btnShoppingItemApp.setOnClickListener {
            val intent = Intent(this, ShoppingActivity::class.java)
            startActivity(intent)
        }
        binding.btnTodolistApiApp.setOnClickListener {
            val intent = Intent(this, TodoListApiActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onBackPressed() {
        val exitAlertDialog = AlertDialog.Builder(this)
            .setIcon(R.drawable.ic_exit)
            .setTitle("Exit")
            .setCancelable(false)
            .setMessage("Do you want to exit?!")
            .setPositiveButton("Yes") { dialogInterface: DialogInterface, i: Int ->
                auth.signOut()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()                }
            .setNegativeButton("No") { dialogInterface: DialogInterface, i: Int ->
                dialogInterface.cancel()
            }
        val alertDialog = exitAlertDialog.create()
        alertDialog.show()
    }
}