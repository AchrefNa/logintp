package com.example.logintp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.logintp.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class Register : AppCompatActivity() {
     lateinit var auth: FirebaseAuth;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityRegisterBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_register)

        auth=FirebaseAuth.getInstance()

        //binding.te .setOnClickListener {
            binding.RegisterBt.setOnClickListener{
                val email=binding.Email.text.toString()
                val password= binding.Password.toString()
                if(email.isEmpty()){
                    Toast.makeText(this,"email is empty",Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                if(password.isEmpty()){
                    Toast.makeText(this,"email is empty",Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this){ task ->
                    if (task.isSuccessful) {

                        Toast.makeText(this,"Compte is created",Toast.LENGTH_SHORT).show()
                    }else {
                        Toast.makeText(this,"Authentification failed",Toast.LENGTH_SHORT).show()
                    }

                }


        }
    }
}