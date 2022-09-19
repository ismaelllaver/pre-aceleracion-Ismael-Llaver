package com.example.challengealkemy.views

import androidx.lifecycle.*
import com.example.challengealkemy.data.MoviesRepository
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModel
import com.example.challengealkemy.data.DetailMovie

class MovieDetailsViewModel(
    private val moviesRepository: MoviesRepository): ViewModel()
{
    val movieDetail =  MutableLiveData<DetailMovie?>()
    private val loading= MutableLiveData<Boolean>(false)

    fun newdetail(id: Int): DetailMovie? {
        loading.value = true
        this.viewModelScope.launch {
            val result = moviesRepository.getDetails(id)

            if(result != null){
                movieDetail.value = result
                             }
            loading.value = false
        }
        return null
    }
}
