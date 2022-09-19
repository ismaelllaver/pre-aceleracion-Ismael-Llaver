package com.example.challengealkemy.views

import com.example.challengealkemy.data.Movie
import com.example.challengealkemy.data.MoviesRepository
import io.mockk.MockKAnnotations
import io.mockk.MockKStubScope
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import okhttp3.Dispatcher
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
internal class MoviesViewModelTest{

    @RelaxedMockK
    private lateinit var  moviesRepository: MoviesRepository

    private lateinit var moviesViewModel: MoviesViewModel

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    class InstantTaskExecutorRule {

    }


    @Before
    fun onBefore(){
        MockKAnnotations.init()
        moviesViewModel = MoviesViewModel(moviesRepository)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }


    @After
    fun onAfter(){
        Dispatchers.resetMain()
           }


    @Test

    fun test1 ()= runTest{
        val movie = listOf(Movie(456,"fall","overview","45324156321","25-6.2020",4581.5,"en"))
        coEvery { moviesRepository.getMovie() } returns movie

        moviesViewModel.newmovie()


        assert(moviesViewModel.movies.value == movie)

    }

}

private infix fun <T, B> MockKStubScope<T, B>.returns(movie: List<Movie>) {

}


