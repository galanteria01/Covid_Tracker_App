package com.shanu.covidtracker.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.shanu.covidtracker.Activity.Contact
import com.shanu.covidtracker.Activity.Login
import com.shanu.covidtracker.R
import kotlinx.android.synthetic.main.fragment_more.*

class MoreFragment:Fragment(R.layout.fragment_more){
    var mAuth:FirebaseAuth?=null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mAuth = FirebaseAuth.getInstance()

        LogoutCard.setOnClickListener {
            mAuth!!.signOut()
            if(mAuth!!.currentUser == null) {
                gotoLogin()
            }
        }

        ContactCard.setOnClickListener {
            gotoContactUs()
        }
    }

    fun gotoLogin(){
        val intent = Intent(context,Login::class.java)
        context!!.startActivity(intent)

    }

    fun gotoContactUs(){
        val intent = Intent(context, Contact::class.java)
        context!!.startActivity(intent)
    }
}