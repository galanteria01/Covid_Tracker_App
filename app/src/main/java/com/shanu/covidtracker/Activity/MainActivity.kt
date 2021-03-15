package com.shanu.covidtracker.Activity

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
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
    private val CHANNEL_ID = "channel_id_001"
    private val notificationId = 101
    var mFirebaseAnalytics:FirebaseAnalytics?=null
    var mAuth:FirebaseAuth?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        createNotificationChannel()
        sendNotification()

        // Testing
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

    private fun createNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Current Covid status"
            val descriptionText = "India"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID,name,importance).apply{
                description = descriptionText
            }
            val notificationManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun sendNotification(){
        val intent = Intent(this,MainActivity::class.java).apply{
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        val pendingIntent = PendingIntent.getActivity(this,0,intent,0)

        val builder = NotificationCompat.Builder(this,CHANNEL_ID)
            .setSmallIcon(R.drawable.icon)
            .setContentTitle("Current Covid status")
            .setContentText("India")
            .setStyle(NotificationCompat.BigTextStyle().bigText("Confirmed:20000 \n Active:10000 \n Death:500"))
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(this)){
            notify(notificationId, builder.build())
        }
    }
}