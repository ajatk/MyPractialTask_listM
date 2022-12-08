package com.example.mypractialtask2

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.mypractialtask2.R
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class UserProjectsFragmentTest{
   @get: Rule
   val activityScenarioRule= ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test_isRecyclerViewVisible(){

    onView(withId(R.id.rv_userProjects)).check(matches(isDisplayed()))
    }

}