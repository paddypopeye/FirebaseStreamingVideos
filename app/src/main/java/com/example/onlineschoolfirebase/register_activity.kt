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
import com.google.firebase.auth.FirebaseUser

class register_activity : AppCompatActivity() {
    var user_email : EditText? = null
    var user_password : EditText? = null
    var register_btn : Button? = null
    var firebaseAuth  : FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_activity)

        user_email = findViewById(R.id.emailAddress)
        user_password = findViewById(R.id.password)
        register_btn = findViewById(R.id.regBtn)
        FirebaseApp.initializeApp(this)
        register_btn?.setOnClickListener{
            RegisterUser()
        }
    }

    fun RegisterUser(){
        var email = user_email?.text.toString().trim()
        var password = user_password?.text.toString().trim()

        if(TextUtils.isEmpty(email)){
            Toast.makeText(applicationContext,"The email field cannot be empty", Toast.LENGTH_LONG).show()
            startActivity(Intent(this@register_activity, MainActivity::class.java))
        }
        else if(TextUtils.isEmpty(password)){
            Toast.makeText(applicationContext,"The password field cannot be empty", Toast.LENGTH_LONG).show()
            startActivity(Intent(this@register_activity, MainActivity::class.java))
        }

        else{

            firebaseAuth?.createUserWithEmailAndPassword(email,password)?.addOnCompleteListener(
                object:OnCompleteListener<AuthResult>{
                    override fun onComplete(task: Task<AuthResult>) {

                        if(task.isSuccessful){
                            Toast.makeText(applicationContext, "Your Account has been Created", Toast.LENGTH_LONG).show()
                            val user =  firebaseAuth!!.currentUser!!

                            user.sendEmailVerification().addOnCompleteListener(object: OnCompleteListener<Void>{
                                override fun onComplete(task: Task<Void>) {
                                    if(task.isSuccessful){
                                        Toast.makeText(applicationContext, "Please check your email", Toast.LENGTH_LONG).show()
                                        startActivity(Intent(this@register_activity, login_activity::class.java))

                                    }

                                    else{
                                        val error = task.exception?.message
                                        Toast.makeText(applicationContext, "An error occured" + error, Toast.LENGTH_LONG).show()

                                    }
                                }

                            })
                        }
                        else{
                            val error = task.exception?.message
                            Toast.makeText(applicationContext, "An error occured please try again!!", Toast.LENGTH_SHORT).show()
                        }

                    }

                })
        }
    }
}
