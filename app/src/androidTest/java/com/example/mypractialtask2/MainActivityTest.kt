package com.example.mypractialtask2

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{


  @Test
  fun test_isActivity_in_view(){
    val activityScenario = ActivityScenario.launch(MainActivity::class.java)
      onView(withId(R.id.main)).check(matches(isDisplayed()))
  }

  @Test
  fun test_isAddtemplateVisible(){
    val activityScenario = ActivityScenario.launch(MainActivity::class.java)
    onView(withId(R.id.addTemplete)).check(matches(isDisplayed()))
    onView(withId(R.id.addTemplete)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
  }

  @Test
  fun test_isFragmentNavigate(){
    val activityScenario = ActivityScenario.launch(MainActivity::class.java)
    onView(withId(R.id.fragment_user_projects)).check(matches(isDisplayed()))

    onView(withId(R.id.addTemplete)).perform(click())

    onView(withId(R.id.llmain)).check(matches(isDisplayed()))
  }
}