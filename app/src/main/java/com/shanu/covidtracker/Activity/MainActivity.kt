package com.shanu.covidtracker.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

import com.shanu.covidtracker.Fragments.HomeFragment
import com.shanu.covidtracker.Fragments.ListFragment
import com.shanu.covidtracker.Fragments.MoreFragment
import com.shanu.covidtracker.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var mFirebaseAnalytics:FirebaseAnalytics?=null
    var mAuth:FirebaseAuth?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)

        // Declaring the fragments
        val homeFragment = HomeFragment()
        val listFragment = ListFragment()
        val moreFragment = MoreFragment()

        // Setting the default fragment
        setCurrentFragment(homeFragment)

        // Bottom nav bar click change handler
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.homeNavItem -> setCurrentFragment(homeFragment)
                R.id.listNavItem -> setCurrentFragment(listFragment)
                R.id.moreNavItem -> setCurrentFragment(moreFragment)
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment)
            commit()
        }
    }
}