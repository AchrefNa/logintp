package com.example.logintp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import com.example.logintp.databinding.ActivityLoginBinding
import com.example.logintp.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainActivity : AppCompatActivity() {
    lateinit var auth: FirebaseAuth;
    lateinit var user: FirebaseUser;
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView
    lateinit var actionToggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )

        initMenu(binding)
        navigateMenu(navView)
        auth = FirebaseAuth.getInstance()
        user = auth.currentUser!!



    }

    private fun initMenu(binding: ActivityMainBinding) {
        drawerLayout = binding.drawerLayout
        navView = binding.navBar

        actionToggle = ActionBarDrawerToggle(this, drawerLayout, binding.toolbar, 0, 0)
        drawerLayout.addDrawerListener(actionToggle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

//make icon menu visible
        actionToggle.syncState()


    }

    private fun navigateMenu(navigationView: NavigationView) {
        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.user -> {

                  /*  val intent = Intent(this, UsersActivity::class.java)
                    startActivity(intent)*/
                    true
                }

                R.id.profile -> {
                    Toast.makeText(
                        baseContext,
                        "profile",
                        Toast.LENGTH_SHORT,
                    ).show()
                    true
                }

                R.id.logout -> {


                        auth.signOut()
                        val intent = Intent(this, Login::class.java)
                        startActivity(intent)


                    true
                }
                else-> {false}
            }


        }

    }
}