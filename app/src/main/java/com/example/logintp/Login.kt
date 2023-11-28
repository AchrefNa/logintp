package com.example.logintp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.logintp.databinding.ActivityLoginBinding
import com.example.logintp.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {
    lateinit var auth: FirebaseAuth;
    override fun onStart() {
        super.onStart()
        val currentUser =auth.currentUser
        if(currentUser!=null){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_login
        )
        auth = FirebaseAuth.getInstance()

        binding.LoginBt.setOnClickListener {
            val email = binding.Email.text.toString()
            val password = binding.Password.text.toString()

            if (email.isEmpty()) {
                Toast.makeText(this, "email is empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                Toast.makeText(this, "password is empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {

                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    } else {

                        Toast.makeText(
                            baseContext,
                            "Authentication failed.",
                            Toast.LENGTH_SHORT,
                        ).show()

                    }
                }


        }
        binding.RegisterNow .setOnClickListener {

            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }


    }
}