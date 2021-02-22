package com.example.petinder

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

const val IMAGE_CHOOSE = 1000
const val PERMISSION_CODE = 1001

class EditProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        // Get the Intent that started this activity
        val profile = intent.getSerializableExtra(EXTRA_PROFILE) as Profile

        val editTextName = findViewById<EditText>(R.id.editTextName)
        editTextName.setText(profile.name)
        val editTextAge = findViewById<EditText>(R.id.editTextAge)
        editTextAge.setText(profile.age.toString())
        val editTextSpecies = findViewById<EditText>(R.id.editTextSpecies)
        editTextSpecies.setText(profile.species)
        val editTextTemperament = findViewById<EditText>(R.id.editTextTemperament)
        editTextTemperament.setText(profile.temperament)
        val editTextLocation = findViewById<EditText>(R.id.editTextLocation)
        editTextLocation.setText(profile.location)
    }

    fun pickPhoto(view: View) {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_CHOOSE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val imageViewProfile = findViewById<ImageView>(R.id.imageViewProfile)

        if (requestCode == IMAGE_CHOOSE && resultCode == Activity.RESULT_OK) {
            imageViewProfile.setImageURI(data?.data)
        }
    }

    fun saveProfile(view: View) {
        val editTextName = findViewById<EditText>(R.id.editTextName)
        val editTextAge = findViewById<EditText>(R.id.editTextAge)
        val editTextSpecies = findViewById<EditText>(R.id.editTextSpecies)
        val editTextTemperament = findViewById<EditText>(R.id.editTextTemperament)
        val editTextLocation = findViewById<EditText>(R.id.editTextLocation)
        val newProfile = Profile(
            editTextName.text.toString(),
            editTextAge.text.toString(),
            editTextSpecies.text.toString(),
            editTextTemperament.text.toString(),
            editTextLocation.text.toString()
        )
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra(EXTRA_PROFILE, newProfile)
        }
        startActivity(intent)
    }
}