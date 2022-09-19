package com.example.challengealkemy.data

import com.google.gson.annotations.SerializedName

data class Movie (
    @SerializedName
        ("id") val id: Int,
    @SerializedName
        ("title") val title: String,
    @SerializedName
        ("overview") var overview: String,
    @SerializedName
        ("poster_path") val posterPath: String,
    @SerializedName
        ("release_date") val releaseDate: String?,
    @SerializedName
        ("popularity") val popularity: Double?,
    @SerializedName
        ("original_language") val originalLeng: String

        )