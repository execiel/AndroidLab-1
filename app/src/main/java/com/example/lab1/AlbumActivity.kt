package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class AlbumActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album)

        // Grab the textView
        val trackTextView: TextView = findViewById(R.id.trackTextView);
        val newTipButton: Button = findViewById(R.id.newTipButton);

        generateTrackTitle(trackTextView)

        newTipButton.setOnClickListener {
            generateTrackTitle(trackTextView)
        }
    }

    fun generateTrackTitle(trackTextView: TextView) {
        // Arrays for the "random" generation
        val prefixes = arrayListOf("Foolish", "The", "Their", "Sleeping", "Subconscious", "Conscious", "Fleeting");
        val endings = arrayListOf("Snow", "Fall", "End", "Doors", "Molecules", "Existence", "Paradigm", "Prism", "Sunlight");
        val songNames = arrayListOf("Beautiful Morning", "Arcadian Flowers", "Hypersun", "Ghost Town", "Seven Days of Falling", "Golden Brown", "I Don't Feel Very Creative")

        // Pick an artist and song name
        val artist = "${prefixes.get(Random.nextInt(prefixes.size))} ${endings.get(Random.nextInt(endings.size))}"
        val track = "${songNames.get(Random.nextInt(songNames.size))}"

        trackTextView.setText("$track \n by: $artist");
    }
}
