package com.example.learnmath1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.app_bar_main.*

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var homeFragment: HomeFragment
    lateinit var profileFragment: ProfileFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setSupportActionBar(toolBar)
        val actionBar = supportActionBar
        actionBar?.title = "Navigation Drawer"

        val drawerToggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle(
            this, drawerLayout, toolBar, (R.string.open), (R.string.close)
        ) {

        }

        drawerToggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        navView.setNavigationItemSelectedListener(this)

        homeFragment = HomeFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameLayout, homeFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.home -> {
                homeFragment = HomeFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frameLayout, homeFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.profile -> {
                profileFragment = ProfileFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frameLayout, homeFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
//            R.id.settings -> {
//                homeFragment = HomeFragment()
//                supportFragmentManager
//                    .beginTransaction()
//                    .replace(R.id.frameLayout, homeFragment)
//                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
//                    .commit()
//            }
            R.id.logout -> {
                startActivity(Intent(this, MainActivity::class.java))
                FirebaseAuth.getInstance().signOut()
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
