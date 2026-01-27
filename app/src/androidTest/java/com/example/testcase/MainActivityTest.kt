package com.example.testcase
import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.core.AllOf.allOf
import org.junit.Rule
import org.junit.Test
import androidx.test.espresso.action.ViewActions.*
import org.junit.runner.RunWith

class MainActivityTest {
    //Rule is a instance of class where as @Before is a method
    @get:Rule
    val activityScenarioRule =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testNextButton_expectedCorrectQuote(){

        onView(withId(R.id.btnNext)).perform(click())
        onView(withId(R.id.btnNext)).perform(click())
        onView(withId(R.id.btnNext)).perform(click())
        onView(withId(R.id.quoteText)).check( matches(withText("Genius is one percent4")))

    }

    @Test
    fun testShareButton_expectedIntentChooser(){
        Intents.init()
        val expected = allOf(hasAction(Intent.ACTION_SEND))
        onView(withId(R.id.floatingActionButton)).perform(click())
        Intents.intended(expected)
        Intents.release()


    }

    //example of test case for text input and show text in next screen
//    @Test
//    fun testSubmitButton_expectedCorrectValues() {
//
//        onView(withId(R.id.txt_title))
//            .perform(typeText("Hello"))
//
//        onView(withId(R.id.txt_description))
//            .perform(typeText("CheezyCode"), closeSoftKeyboard())
//
//        onView(withId(R.id.btn_submit))
//            .perform(click())
//
//        onView(withId(R.id.txt_message))
//            .check(matches(withText("Title - Hello | Desc - CheezyCode")))
//    }


}