package com.example.petinder

import android.net.Uri
import java.io.Serializable

class Profile(
        _name: String = "MogoC",
        _age: String = "30",
        _species: String = "Desert Tortoise",
        _temperament: String = "Stoic, Reliable, Tough, Slothful",
        _location: String = "Las Vegas, Nevada",
        _profilePicture: String = "android.resource://com.example.petinder/" + R.drawable.mogo
) : Serializable {
    var name = _name
    var age = _age.toInt()
    var species = _species
    var temperament = _temperament
    var location = _location
    var profilePicture = _profilePicture
}