package com.example.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // Grab views
        val signUpButton: Button = findViewById(R.id.signUpButton)

        val errorTextView: TextView = findViewById(R.id.errorTextView)

        val usernameInput: EditText = findViewById(R.id.usernameInput)
        val passwordInput: EditText = findViewById(R.id.passwordInput)
        val verPasswordInput: EditText = findViewById(R.id.verifyPasswordInput)

        signUpButton.setOnClickListener {
            verifyAndNavigate(
                usernameInput.text.toString(),
                passwordInput.text.toString(),
                verPasswordInput.text.toString(),
                errorTextView);
        }

    }

    fun verifyAndNavigate(username: String, pass: String, verPass: String, errorText: TextView) {
        if(pass != verPass) {
            errorText.setText("Passwords didn't match")
            return
        }

        val navLogInIntent = Intent(this, LoginActivity::class.java).apply {
            putExtra("key_signedup_username", username)
            putExtra("key_signedup_password", pass)
        }

        startActivity(navLogInIntent)
    }
}