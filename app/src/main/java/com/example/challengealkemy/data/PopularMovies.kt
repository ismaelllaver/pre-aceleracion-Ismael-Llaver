package com.example.challengealkemy.data

import com.google.gson.annotations.SerializedName

class PopularMovies(

    @SerializedName("page") val page: Int,
    @SerializedName("results") val movies: List<Movie>)