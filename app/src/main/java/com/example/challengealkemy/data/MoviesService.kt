package com.example.challengealkemy.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesService {
    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String): Call<PopularMovies>
    @GET("movie/{movie_id}")
    fun getDetails(@Path("movie_id") id: Int,@Query("api_key") apiKey: String): Call<DetailMovie>

}
