package com.example.challengealkemy.views

import android.content.Intent
import io.mockk.*
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test


internal class MainActivityTest(){

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExcecutorRule()

    class InstantTaskExcecutorRule {

    }

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    class MainCoroutineRule {

    }


    @RelaxedMockK
    private lateinit var mainActivity: MainActivity


    @Before
    fun onBefore(){
        MockKAnnotations.init()
        mainActivity = MainActivity()
    }


    @Test
    fun getIdAndPassToActivity() = runBlocking{
        var id: Int = 0
        val intent: Intent

        coEvery  { val intent = Intent(mainActivity,DetailActivity::class.java)
            intent.putExtra("id",id) }

        mainActivity.goDetail(id)


        coVerify{  mainActivity.run { startActivity(any()) } }


    }


}