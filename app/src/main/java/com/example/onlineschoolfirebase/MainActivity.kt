package com.example.onlineschoolfirebase

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun login(view: View){
        startActivity(Intent(this@MainActivity, login_activity::class.java))
    }

    fun register(view:View){
        startActivity(Intent(this@MainActivity, register_activity::class.java))
    }
}
