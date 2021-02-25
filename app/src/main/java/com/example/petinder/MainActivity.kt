package com.example.petinder

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi

const val EXTRA_PROFILE = "com.example.petinder.PROFILE"

class MainActivity : AppCompatActivity() {
    var profile: Profile = Profile()

    // TODO: LOOK INTO THIS
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the Intent that started this activity
        profile = if (intent.getSerializableExtra(EXTRA_PROFILE) == null) Profile()
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
        val imageViewBackground = findViewById<ImageView>(R.id.imageViewBackground)
        imageViewBackground.setImageURI(Uri.parse(profile.profilePicture))
    }

    /** Called when the user taps the pencil button */
    fun editProfile(view: View) {
        val intent = Intent(this, EditProfileActivity::class.java).apply {
            putExtra(EXTRA_PROFILE, profile)
        }
        startActivity(intent)
    }

    /** Called when the user taps the search button */
    fun browseProfiles(view: View) {
        val intent = Intent(this, BrowsingActivity::class.java).apply {
            putExtra(EXTRA_PROFILE, profile)
        }
        startActivity(intent)
    }
}