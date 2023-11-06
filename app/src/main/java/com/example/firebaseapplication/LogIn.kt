package com.example.firebaseapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.google.firebase.auth.FirebaseAuth

class LogIn : AppCompatActivity() {
    private lateinit var firebaseAuth:FirebaseAuth
    private lateinit var btnBack : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
    setContentView(R.layout.activity_log_in)
        super.onCreate(savedInstanceState)

        firebaseAuth = FirebaseAuth.getInstance()

    val logInButtonn : AppCompatButton = findViewById(R.id.btnLogInAccount)
    logInButtonn.setOnClickListener{
        performLogIn()
    }

    btnBack = findViewById(R.id.btnBack)
    btnBack.setOnClickListener{
        onBackPressedDispatcher.onBackPressed()
    }

    }
    private fun  performLogIn(){
        val emaill : EditText = findViewById(R.id.editTextEmailLogIn)
        val passs : EditText = findViewById(R.id.editTextPasswordLogIn)
        if(emaill.text.isEmpty() || passs.text.isEmpty()){
            Toast.makeText(this, "შეავსეთ ველები", Toast.LENGTH_SHORT)
                .show()
            return
        }
        val emailInput = emaill.text.toString()
        val passInput = passs.text.toString()
        firebaseAuth.signInWithEmailAndPassword(emailInput,passInput)
            .addOnCompleteListener {task->
                if(task.isSuccessful){
                    startActivity(Intent(this,LogeInPage::class.java))
                    finish()
                } else{
                    Toast.makeText(

                        this,
                        task.exception!!.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

    }
}