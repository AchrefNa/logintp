package com.example.logintp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

   // lateinit var contactAdapter: ContactAdapter
  //  lateinit var storiesAdapter: StoriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )

        initMenu(binding)
        navigateMenu(navView)
      /*  val buttonLogout: Button = findViewById(R.id.buttonLogout)
        buttonLogout.setOnClickListener {
            auth.signOut()
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }*/

        auth = FirebaseAuth.getInstance()
        user = auth.currentUser!!



    /*
         contacts = createContacts()
        val rcl: RecyclerView = findViewById(R.id.rvContacts)

       val contactAdapter = ContactAdapter(this, contacts)

        rcl.adapter = contactAdapter
        rcl.layoutManager = GridLayoutManager(this,2) //LinearLayoutManager(this)

        rcl.addItemDecoration(StoriesDecoration(6))

        contactAdapter.onItemClick={
            val intent = Intent(this, DetailedActivity::class.java)
            intent.putExtra("contact",it)
            startActivity(intent)
        }*/
        ////////////////////////////////////////////////////////





/////////////////////////////////////////////////////////////////////////
   /*     storiesAdapter=StoriesAdapter(this, contacts)
        val storyBar: RecyclerView = findViewById(R.id.storiesBar)
        storyBar.adapter = storiesAdapter
        storyBar.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)

        storyBar.addItemDecoration(StoriesDecoration(6))
        storiesAdapter.onItemClick={
*/
/*
            val currentstory=MyStory(
                "https://fastly.picsum.photos/id/2/200/300.jpg?hmac=HiDjvfge5yCzj935PIMj1qOf4KtvrfqWX3j4z1huDaU",
                SimpleDateFormat("MM/dd/yyyy").parse("08/10/2022"),
                "fefef"
            )

            listStories.add(currentstory)





                StoryView.Builder(supportFragmentManager)
                    .setStoriesList(listStories)
                    .setStoryDuration(5000) // Optional, default is 2000 Millis
                    .setTitleText(contacts[0].name)
                    .setSubtitleText(" bbb")
                    .setTitleLogoUrl(contacts[0].imageUrl)// MyStory's ArrayList
                    .setStoryClickListeners(object : StoryClickListeners {
                        override fun onDescriptionClickListener(position: Int) {
                            // your action
                        }

                        override fun onTitleIconClickListener(position: Int) {
                            // your action
                        }
                    }) // Optional Listeners
                    .build() // Must be called before show method
                    .show()


*/
     //   }


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

    private fun createContacts(): List<Contact> {
        val contacts = mutableListOf<Contact>()

        for (i in 1..150) contacts.add(Contact("Person#$i", i,false))
        return contacts
    }


}