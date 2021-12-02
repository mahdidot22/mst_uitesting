package com.mahdi.d.o.taha.recycleruitesting

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario.ActivityAction
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers
import org.hamcrest.core.AllOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
public class RecyclerTest {
    val RecyclerId:Int = R.id.myRecyclerView
    private lateinit var  recyclerView:RecyclerView
    private final val TEXT_ITEM_15:String = "Text15"
    private final val TEXT_ITEM_7:String = "Text7"
    private final val LAST_ITEM_ID:String = "Text17"

    @get:Rule
    val rule: ActivityScenarioRule<DataActivity> = ActivityScenarioRule(DataActivity::class.java)

    @Before
    fun setUpTest() {
        rule.scenario.onActivity {
            recyclerView = it.findViewById(RecyclerId)
        }
    }

    @Test
    fun RecyclerView_isCorrect() {
        // check Recycler view is visible
        Espresso.onView(withId(RecyclerId))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun lastItem_NotDisplayed() {
        // Last item should not exist if the list wasn't scrolled down.
        Espresso.onView(ViewMatchers.withText(LAST_ITEM_ID))
            .check(ViewAssertions.doesNotExist())
    }

    @Test
    fun lastItem_IsDisplayed() {
        // Last item should exist if the list wasn't scrolled down.
        Espresso.onView(ViewMatchers.withText(LAST_ITEM_ID))
            .check(ViewAssertions.matches(Matchers.not(ViewAssertions.doesNotExist())))
    }


    /**
     * Check that the item is created. onData() takes care of scrolling.
     */
    @Test
    fun list_Scrolls() {
        Espresso.onData(Matchers.equalTo(LAST_ITEM_ID))
            .check(ViewAssertions.matches(ViewMatchers.isCompletelyDisplayed()))
    }


    /**
     * Clicks on a row and checks that the activity detected the click.
     */
    @Test
    fun row_Click() {
        Espresso.onData(AllOf.allOf())
            .inAdapterView(withId(R.id.myRecyclerView))
            .atPosition(15)
            .perform(ViewActions.click())
    }



}