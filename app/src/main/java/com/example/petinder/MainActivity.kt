package com.example.petinder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

const val EXTRA_PROFILE = "com.example.petinder.PROFILE"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the Intent that started this activity
        var profile = if (intent.getSerializableExtra(EXTRA_PROFILE) == null) Profile()
            else intent.getSerializableExtra(EXTRA_PROFILE) as Profile

        val textViewName = findViewById<TextView>(R.id.textViewName)
        textViewName.text = profile.name
        val textViewAge = findViewById<TextView>(R.id.textViewAge)
        textViewAge.text = profile.age.toString()
        val textViewSpecies = findViewById<TextView>(R.id.textViewSpecies)
        textViewSpecies.text = profile.species
        val textViewTemperament = findViewById<TextView>(R.id.textViewTemperament)
        textViewTemperament.text = profile.temperament
        val textViewLocation = findViewById<TextView>(R.id.textViewLocation)
        textViewLocation.text = profile.location
    }

    /** Called when the user taps the Send button */
    fun editProfile(view: View) {
        val textViewName = findViewById<TextView>(R.id.textViewName)
        val textViewAge = findViewById<TextView>(R.id.textViewAge)
        val textViewSpecies = findViewById<TextView>(R.id.textViewSpecies)
        val textViewTemperament = findViewById<TextView>(R.id.textViewTemperament)
        val textViewLocation = findViewById<TextView>(R.id.textViewLocation)
        val newProfile = Profile(
                textViewName.text.toString(),
                textViewAge.text.toString(),
                textViewSpecies.text.toString(),
                textViewTemperament.text.toString(),
                textViewLocation.text.toString()
        )
        val intent = Intent(this, EditProfileActivity::class.java).apply {
            putExtra(EXTRA_PROFILE, newProfile)
        }
        startActivity(intent)
    }
}