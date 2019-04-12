package com.example.onlineschoolfirebase

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class login_activity : AppCompatActivity() {
    var user_email_login : EditText? = null
    var user_psswrd_login  : EditText? = null
    var loginBtn : Button? = null
    var firebaseAuth : FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_activity)

        user_email_login = findViewById(R.id.emailAddress)
        user_psswrd_login = findViewById(R.id.login_password)
        FirebaseApp.initializeApp(this)
        firebaseAuth = FirebaseAuth.getInstance()

        loginBtn?.setOnClickListener {
            LoginUser()
        }
    }

    private fun LoginUser(){
        var email  = user_email_login?.text.toString().trim()
        var password = user_psswrd_login?.text.toString().trim()

        if(TextUtils.isEmpty(email)){

            Toast.makeText(applicationContext, "The email field cannot be empty..", Toast.LENGTH_LONG).show()
        }

        else if(TextUtils.isEmpty(password)){

            Toast.makeText(applicationContext, "The password field cannot be empty..", Toast.LENGTH_LONG).show()
        }

        else{
            firebaseAuth?.signInWithEmailAndPassword(email,password)?.addOnCompleteListener(object: OnCompleteListener<AuthResult>{
                override fun onComplete(auth: Task<AuthResult>) {
                        if(auth.isSuccessful){
                            Toast.makeText(applicationContext,"You are now logged in", Toast.LENGTH_LONG).show()
                        }
                        else{
                            val error = auth.exception?.message
                            Toast.makeText(applicationContext, "An error occurred ..." + error, Toast.LENGTH_LONG).show()
                            startActivity(Intent(this@login_activity, dashboard_activity::class.java))
                        }
                }
            })
        }
    }

}