package com.example.logintp.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.logintp.Login
import com.example.logintp.databinding.FragmentDashboardBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class FragmentDashboard : Fragment() {
    lateinit var auth: FirebaseAuth;
    lateinit var user: FirebaseUser;
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val binding =

            FragmentDashboardBinding.inflate(layoutInflater, container, false)


        auth = FirebaseAuth.getInstance()
        user = auth.currentUser!!

        setData(binding)
        return binding.root}

    private fun setData(binding: FragmentDashboardBinding) {
        binding.tvDetails .text = user.email
        binding.btnLogout .setOnClickListener {
            auth.signOut()
            val intent = Intent(context, Login::class.java)
            startActivity(intent)
        }
    }
}