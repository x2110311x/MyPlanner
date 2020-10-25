package com.asweeney.myplanner

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.firebase.ui.auth.AuthUI
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.squareup.picasso.Picasso

class NavMenuActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav_menu)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val auth = FirebaseAuth.getInstance()
        if (auth.currentUser == null) {
            val intent = Intent(this, SignInActivity::class.java).apply {
            }
            startActivity(intent)
        }

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.nav_home, R.id.nav_bucket, R.id.nav_calendar, R.id.nav_list, R.id.nav_settings), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val username: String? = auth.currentUser?.displayName
        val email: String? = auth.currentUser?.email
        val userImageUrl: String? = auth.currentUser?.photoUrl.toString()

        val usernameTxt: TextView = navView.getHeaderView(0).findViewById(R.id.nav_username)
        val emailTxt: TextView  = navView.getHeaderView(0).findViewById(R.id.nav_email)
        val userImage: ImageView = navView.getHeaderView(0).findViewById(R.id.nav_userimage)

        usernameTxt.text = username
        emailTxt.text = email
        Picasso.get().load(userImageUrl).resize(196,196).into(userImage)
        val signout: TextView = navView.getHeaderView(0).findViewById(R.id.nav_signout)
        signout.setOnClickListener{
            AuthUI.getInstance().signOut(this)
            Toast.makeText(applicationContext, "You have been signed out", Toast.LENGTH_SHORT).show()
            this.finishAffinity();
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.nav_menu, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}