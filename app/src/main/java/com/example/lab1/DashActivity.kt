package com.example.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash)

        // Grab views
        val greetingTextView: TextView = findViewById(R.id.greetingTextView)
        val viewButton: Button = findViewById(R.id.viewTipButton)

        // Greet user
        val username = intent.getStringExtra("key_username").toString();
        greetingTextView.setText("Greetings $username!");

        // Create navigation intent
        val navAlbumIntent = Intent(this, AlbumActivity::class.java);

        viewButton.setOnClickListener {
            startActivity(navAlbumIntent)
        }

    }
}