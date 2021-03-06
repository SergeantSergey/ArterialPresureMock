package com.github.kadehar.arterialpressureapp.assertions

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

class CustomAssertions {
    companion object {
        fun itemCount(matcher: Matcher<Int>): ViewAssertion =
            ItemCountAssertion(matcher)
    }

    private class ItemCountAssertion(private val matcher: Matcher<Int>) :
        ViewAssertion {
        override fun check(view: View, noViewFoundException: NoMatchingViewException?) {
            if (noViewFoundException != null) {
                throw noViewFoundException
            }

            if (view !is RecyclerView) {
                throw IllegalStateException("The asserted view is not RecyclerView")
            }

            if (view.adapter == null) {
                throw IllegalStateException("No adapter is assigned to RecyclerView")
            }

            ViewMatchers.assertThat(
                "RecyclerView item count",
                view.adapter?.itemCount,
                matcher
            )
        }
    }
}