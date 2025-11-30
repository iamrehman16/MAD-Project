package com.example.myapplication.ui.model

data class User(
    val name: String,
    val email: String,
    val memberSince: String,
    val avatarUrl: String? = null // optional, can load image later
)
