package com.example.challengealkemy.data

class MoviesRepository(
    private val remoteDataSource: MoviesRemoteDataSource
) {

    suspend fun getMovie(): PopularMovies? {
        return this.remoteDataSource.getMovie()
    }

    suspend fun getDetails(id: Int): DetailMovie? {
        return this.remoteDataSource.getDetails(id)
    }
}