package com.apps.fullandroidcourseclassc.ui

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.apps.fullandroidcourseclassc.*
import com.apps.fullandroidcourseclassc.authsystem.LoginActivity
import com.apps.fullandroidcourseclassc.databinding.ActivityBaseBinding
import com.apps.fullandroidcourseclassc.ui.fragments.ArchiveFragment
import com.apps.fullandroidcourseclassc.ui.fragments.InboxFragment
import com.apps.fullandroidcourseclassc.ui.fragments.SendFragment
import com.apps.fullandroidcourseclassc.ui.fragments.StarredFragment

class BaseActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var binding: ActivityBaseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBaseBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setCurrentFragment(InboxFragment()) // Set InboxFragment as Main Layout
        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open, R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.miInbox -> {
                    val inboxFragment = InboxFragment()
                    setCurrentFragment(inboxFragment)
                    binding.drawerLayout.close()

                }
                R.id.miSent -> {
             val sendFragment = SendFragment()
                    setCurrentFragment(sendFragment)
                    binding.drawerLayout.close()
                }
                R.id.miStarred -> {
                    val starredFragment = StarredFragment()
                    setCurrentFragment(starredFragment)
                    binding.drawerLayout.close()
                }
                R.id.miArchive -> {
                    val archiveFragment = ArchiveFragment()
                    setCurrentFragment(archiveFragment)
                    binding.drawerLayout.close()
                }
                R.id.miLogOut -> {
                    val exitAlertDialog = AlertDialog.Builder(this)
                        .setIcon(R.drawable.ic_logout)
                        .setTitle("Exit")
                        .setCancelable(false)
                        .setMessage("Do you want to exit ?!")
                        .setPositiveButton("Yes") { dialogInterface: DialogInterface, i: Int ->
                            val intent = Intent(this, LoginActivity::class.java)
                            startActivity(intent)
                            finish()
                        }
                        .setNegativeButton("No") { dialogInterface: DialogInterface, i: Int ->
                            dialogInterface.cancel() // cancel
                        }
                    val alertDialog = exitAlertDialog.create()
                    alertDialog.show()
                }
            }
            true
        }


    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)

    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.clContent, fragment)
            commit() // apply changes
        }
}