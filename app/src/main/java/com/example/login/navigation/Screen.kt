package com.example.login.navigation

import kotlinx.serialization.Serializable

@Serializable
object Login

@Serializable
data class Home(val userEmail: String)