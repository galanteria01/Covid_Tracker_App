package com.shanu.covidtracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

import com.shanu.covidtracker.Fragments.HomeFragment
import com.shanu.covidtracker.Fragments.ListFragment
import com.shanu.covidtracker.Fragments.MoreFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val listFragment = ListFragment()
        val moreFragment = MoreFragment()

        setCurrentFragment(homeFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.homeNavItem -> setCurrentFragment(homeFragment)
                R.id.listNavItem -> setCurrentFragment(listFragment)
                R.id.moreNavItem -> setCurrentFragment(moreFragment)


            }
            true
        }
    }

    fun setCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment)
            commit()
        }
    }
}