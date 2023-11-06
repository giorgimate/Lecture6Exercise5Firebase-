package com.example.firebaseapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.example.firebaseapplication.databinding.ActivityRegisterStep2Binding
import com.google.firebase.auth.FirebaseAuth


class RegisterStep2 : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterStep2Binding
    private lateinit var firebaseAuth : FirebaseAuth
    private lateinit var etUserName : EditText
    private lateinit var btnBack : ImageButton
    private lateinit var btnSignUp : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterStep2Binding.inflate(layoutInflater)




        val email = intent.getStringExtra("email")?:""
        val password = intent.getStringExtra("password")?:""
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()




        etUserName = findViewById(R.id.editTextUserName)
        btnBack = findViewById(R.id.btnBack)
        btnSignUp = findViewById(R.id.btnRegisterSignUpStage)
        btnBack.setOnClickListener{
            onBackPressedDispatcher.onBackPressed()
        }
        binding.btnRegisterSignUpStage.setOnClickListener{
            registerUser(email,password)
        }


    }

    private fun registerUser(eml:String, psw:String){
        val username = binding.editTextUserName.text.toString()
        if(username.length > 4 ){
            firebaseAuth.createUserWithEmailAndPassword(eml, psw)
                .addOnCompleteListener(RegisterStep2()){ task->
                    if(task.isSuccessful){
                        Toast.makeText(
                            this,
                            " User added successfully",
                            Toast.LENGTH_SHORT
                        ).show()
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }else{
                        firebaseAuth.signInWithEmailAndPassword(eml,psw)
                            .addOnCompleteListener {mTask->
                                if(mTask.isSuccessful){
                                    startActivity(Intent(this,MainActivity::class.java))
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
        } else{
            etUserName.error = getString(R.string.username_error)
        }
    }
}





