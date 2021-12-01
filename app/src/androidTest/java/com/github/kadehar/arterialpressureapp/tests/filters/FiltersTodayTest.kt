package com.github.kadehar.arterialpressureapp.tests.filters

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.kadehar.arterialpressureapp.R
import com.github.kadehar.arterialpressureapp.assertions.CustomAssertions.Companion.itemCount
import com.github.kadehar.arterialpressureapp.tests.TestBase
import org.hamcrest.Matchers.`is`
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FiltersTodayTest : TestBase() {
    @Test
    fun `Filters-Today`() {
        createNewAPCard()

        onView(withId(R.id.arterialPressureFilters)).perform(
            RecyclerViewActions
                .actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    click()
                )
        )

        onView(withId(R.id.arterialPressureList))
            .check(itemCount(`is`(1)))
    }

    @After
    fun tearDown() {
        onView(withId(R.id.apDeleteIcon)).perform(click())
    }
}