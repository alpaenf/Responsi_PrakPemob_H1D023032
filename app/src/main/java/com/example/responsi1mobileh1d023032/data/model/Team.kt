package com.example.responsi1mobileh1d023032.data.model

data class Team(
    val id: Int,
    val name: String,
    val crestUrl: String,
    val coach: Coach?,
    val squad: List<Player>?
)
