package com.example.logintp.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.logintp.Contact
import com.example.logintp.ContactAdapter
import com.example.logintp.DetailedActivity
import com.example.logintp.Login
import com.example.logintp.R
import com.example.logintp.StoriesAdapter
import com.example.logintp.StoriesDecoration
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

        val contacts = createContacts()

        binding.storiesBar.setHasFixedSize(true)

        val storiesAdapter = StoriesAdapter(requireContext(), contacts)
        binding.storiesBar.adapter = storiesAdapter



        binding.storiesBar.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)

        binding.storiesBar.addItemDecoration(StoriesDecoration(6))
        storiesAdapter.onItemClick = {

        }

        binding.rvContacts.setHasFixedSize(true)
        val contactAdapter = ContactAdapter(requireContext(), contacts)

        binding.rvContacts.adapter = contactAdapter
        binding.rvContacts.layoutManager =
            GridLayoutManager(requireContext(), 2) //LinearLayoutManager(this)

        binding.rvContacts.addItemDecoration(StoriesDecoration(6))

      contactAdapter.onItemClick = {clickedContact ->
            val intent = Intent(activity, DetailedActivity::class.java)
            intent.putExtra("contact", clickedContact)
            startActivity(intent)
        }



        setData(binding)
        return binding.root
    }

    private fun setData(binding: FragmentDashboardBinding) {
        binding.tvDetails.text = user.email
       /* binding.btnLogout.setOnClickListener {
            auth.signOut()
            val intent = Intent(context, Login::class.java)
            startActivity(intent)
        }*/
    }

    private fun createContacts(): List<Contact> {
        val contacts = mutableListOf<Contact>()

        for (i in 1..150) contacts.add(Contact("Image", i, false))
        return contacts
    }
}