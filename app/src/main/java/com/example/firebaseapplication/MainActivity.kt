package com.example.firebaseapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var register : Button
    private lateinit var loggIn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        register = findViewById(R.id.btnRegister)
        loggIn = findViewById(R.id.btnLogIn)
        register.setOnClickListener{
            val intent = Intent(this,RegisterStep1::class.java)
            startActivity(intent)
        }
        loggIn.setOnClickListener{
            val intent = Intent (this, LogIn::class.java)
            startActivity(intent)
        }

    }
}