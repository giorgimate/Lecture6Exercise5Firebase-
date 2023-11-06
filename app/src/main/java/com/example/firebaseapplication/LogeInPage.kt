package com.example.firebaseapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton

class LogeInPage : AppCompatActivity() {
    private lateinit var btnLogOut: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loge_in_page)
        btnLogOut = findViewById(R.id.btnLogOut)
        btnLogOut.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}