package com.shanu.covidtracker.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.shanu.covidtracker.R
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {
    private var mAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        mAuth = FirebaseAuth.getInstance()
        signupButton.setOnClickListener {
            signupWithDetails(textEmail.text.toString(),textPassword.text.toString())
        }
        loginButton.setOnClickListener {
            loginWithDetails(textEmail.text.toString(),textPassword.text.toString())
        }
    }

    override fun onStart() {
        super.onStart()
        val currentUser = mAuth!!.currentUser
        if(currentUser!=null){
            updateUI(currentUser)
        }

    }

    fun signupWithDetails(email:String,password:String){
        mAuth!!.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this){
            task ->
            if(task.isSuccessful){
                val user = mAuth!!.currentUser
                updateUI(user)

            }else{
                Toast.makeText(baseContext, "Authentication failed.",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun loginWithDetails(email:String,password: String){
        mAuth!!.signInWithEmailAndPassword(email,password).addOnCompleteListener(this){
            task ->
            if(task.isSuccessful){
                val user = mAuth!!.currentUser
                updateUI(user)


            }else{
                Toast.makeText(baseContext, "Authentication failed.",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun updateUI(user:FirebaseUser?){
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("user",user)
        startActivity(intent)
        finish()
    }
}