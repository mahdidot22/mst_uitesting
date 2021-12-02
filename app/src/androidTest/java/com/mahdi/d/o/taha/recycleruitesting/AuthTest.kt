package com.mahdi.d.o.taha.recycleruitesting

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class AuthTest {


    @get:Rule
    val rule:ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    @Test
    @Throws(InterruptedException::class)
    fun check_ui_login() {
        val Email = "Mahdi@test.com"
        val Password = "123456789"


        //View Actions (1,2) - closeSoftKeyboard/typeText
        Espresso.onView(withId(R.id.ed_email))
            .perform(ViewActions.typeText(Email), ViewActions.closeSoftKeyboard())
        Espresso.onView(withId(R.id.ed_psw))
            .perform(ViewActions.typeText(Password), ViewActions.closeSoftKeyboard())
        Espresso.onView(withId(R.id.ed_email))
            .check(ViewAssertions.matches(ViewMatchers.withText(Email)))
        Espresso.onView(withId(R.id.ed_psw))
            .check(ViewAssertions.matches(ViewMatchers.withText(Password)))

        //View Actions (3) - click
        Espresso.onView(withId(R.id.btn_login)).perform(ViewActions.click())
    }
}