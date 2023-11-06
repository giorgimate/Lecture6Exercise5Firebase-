package com.example.firebaseapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton

class RegisterStep1 : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnNext: Button
    private lateinit var btnBack: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_step1)
        etEmail = findViewById(R.id.editTextEmail)
        etPassword = findViewById(R.id.editTextpassword)
        btnNext = findViewById(R.id.btnRegisterNextStage)
        btnBack = findViewById(R.id.btnBack)

        btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        btnNext.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (validateEmailAndPassword(email, password)) {
                val intent = Intent(this, RegisterStep2::class.java)
                intent.putExtra(BUNDLE_EMAIL_KEY, email)
                intent.putExtra(BUNDLE_EMAIL_PASSWORD, password)
                startActivity(intent)
            }
        }
    }

    private fun validateEmailAndPassword(email: String, password: String): Boolean {
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.error = getString(R.string.email_error)
            return false
        } else if (password.length < 5) {
            etPassword.error = getString(R.string.password_error)
            return false
        }
        return true
    }

    companion object {
        const val BUNDLE_EMAIL_KEY = "email"
        const val BUNDLE_EMAIL_PASSWORD = "password"
    }
}
