package com.example.challengealkemy.data


import com.example.challengealkemy.BuildConfig.API_KEY
import retrofit2.Response
import retrofit2.awaitResponse

import kotlin.Exception

class MoviesRemoteDataSource {


    suspend fun getMovie(): PopularMovies?
    {

        val service = RetrofitService.instance.create(MoviesService::class.java).getPopularMovies(API_KEY)

         try {
            val response: Response<PopularMovies> = service.awaitResponse()
            val movie = response.body()
             return movie
            if (movie != null) {
                RepositoryResult(data = movie)
            } else {
                 RepositoryResult(errorMessage = "El servidor rechazo la operacion")
            }
        } catch (e: Exception) {
               RepositoryResult(errorMessage = "Error")
        }
        return null
    }

    suspend fun getDetails(id: Int): DetailMovie?{
        val service = RetrofitService.instance.create(MoviesService::class.java).getDetails(id, API_KEY)

        try{
            val response: Response<DetailMovie> = service.awaitResponse()
            val movie = response.body()
            return movie
        }catch(e: Exception){
            return null
        }
    }

}