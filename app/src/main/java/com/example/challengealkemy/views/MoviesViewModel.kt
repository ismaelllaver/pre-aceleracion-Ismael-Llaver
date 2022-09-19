package com.example.challengealkemy.views

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.challengealkemy.data.Movie
import com.example.challengealkemy.data.MoviesRepository
import kotlinx.coroutines.launch

class MoviesViewModel(
    private val moviesRepository: MoviesRepository
): ViewModel() {

    val movies= MutableLiveData<List<Movie>?>()
    val error = MutableLiveData<String?>(null)
    val loading= MutableLiveData<Boolean>(false)

    fun newmovie():List<Movie>?  {
        loading.value = true
        this.viewModelScope.launch {
            val result  = moviesRepository.getMovie()
            if(result != null){
                movies.value = result.movies
            }
            else{
                error.value = (error?: "Ocurrio algo inesperado") as String?
            }
            loading.value = false
        }
        return null
    }
}