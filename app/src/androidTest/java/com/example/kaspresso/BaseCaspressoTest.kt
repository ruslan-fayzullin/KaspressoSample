package com.example.kaspresso

import androidx.test.rule.ActivityTestRule
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule

open class BaseCaspressoTest : TestCase(Kaspresso.Builder.simple()) {

    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java, false, true)


}