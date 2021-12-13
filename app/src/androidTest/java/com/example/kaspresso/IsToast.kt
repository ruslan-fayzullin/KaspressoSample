package com.example.kaspresso

import android.view.View
import android.view.WindowManager
import androidx.test.espresso.Root
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher

class IsToast : TypeSafeMatcher<Root>() {
    override fun describeTo(description: Description?) {
        description?.appendText("is toast")
    }

    override fun matchesSafely(item: Root?): Boolean {
        item?.let {
            val type = it.windowLayoutParams?.get()?.type
            if (type == WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY) {
                val windowToken = it.decorView?.windowToken
                val appToken = it.decorView?.applicationWindowToken
                if (windowToken == appToken) {
                    return true
                }
            }
        }
        return false
    }

    companion object {
        fun isToast(): Matcher<Root> = IsToast()
    }
}