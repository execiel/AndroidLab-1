package com.example.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Try to grab username from signup screen
        val signedupUsername = intent.getStringExtra("key_signedup_username")
        val signedupPassword = intent.getStringExtra("key_signedup_password")

        // Grab views
        val signUpButton: Button = findViewById(R.id.signUpButton)
        val logInButton: Button = findViewById(R.id.logInButton)

        val errorText: TextView = findViewById(R.id.errorText)

        val usernameInput: EditText = findViewById(R.id.usernameInput)
        val passwordInput: EditText = findViewById(R.id.passwordInput)

        // Sign up activity navigation intent
        val navSignUpIntent = Intent(this, SignUpActivity::class.java);

        // Listeners for the buttons
        signUpButton.setOnClickListener {
            startActivity(navSignUpIntent);
        }

        logInButton.setOnClickListener() {
            verifyAndLogIn(
                usernameInput.text.toString(),
                passwordInput.text.toString(),
                signedupUsername.toString(),
                signedupPassword.toString(),
                errorText);
        }
    }

    fun verifyAndLogIn(username: String, pass: String, signedUsername: String, signedPass: String, errorText: TextView) {
        // Make sure user have signed up
        if(signedUsername == "null" || signedPass == "null") {
            errorText.setText("Could not find user with that username or password")
            return
        }

        // Make sure fields aren't empty
        if(username == "" || pass == "") {
            errorText.setText("Please enter both username and password")
            return
        }

        // Make sure credentials aren't different
        if(username != signedUsername || pass != signedPass) {
            errorText.setText("Either username or password is incorrect")
            return
        }

        val navDashIntent = Intent(this, DashActivity::class.java).apply {
            putExtra("key_username", username)
        }

        startActivity(navDashIntent)
    }
}