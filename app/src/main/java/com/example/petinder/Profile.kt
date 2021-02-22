package com.example.petinder

import java.io.Serializable

class Profile(
        _name: String = "MogoC",
        _age: String = "30",
        _species: String = "Desert Tortoise",
        _temperament: String = "Stoic, Reliable, Tough, Slothful",
        _location: String = "Las Vegas, Nevada"
) : Serializable {
    val name = _name
    val age = _age.toInt()
    val species = _species
    val temperament = _temperament
    val location = _location
}