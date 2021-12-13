package com.example.kaspresso

import com.agoda.kakao.common.builders.ViewBuilder
import com.agoda.kakao.common.views.KView
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import com.kaspersky.kaspresso.screens.KScreen

object CounterScreen : KScreen<CounterScreen>() {
    override val layoutId: Int = R.layout.fragment_counter
    override val viewClass: Class<*> = CounterFragment::class.java

    val tvCounter = KTextView {
        withId(R.id.tv_counter)
    }

    val btnIncreaseCounter = KButton {
        withId(R.id.btn_increase_counter)
    }

    val btnDecreaseCounter = KButton {
        withId(R.id.btn_decrease_counter)
    }

    val btnOpenTodo = KButton {
        withId(R.id.btn_open_todo_screen)
    }

    private fun getToast(text: String, action: ViewBuilder.() -> Unit) = KView {
        withText(text)
        action()
    }

    fun checkToastVisibility(text: String) {
        getToast(text) {
            isVisible()
        }
    }

    fun checkTvCounter() {
        tvCounter {
            isVisible()
        }
    }

    fun checkButtons() {
        btnIncreaseCounter { isVisible() }
        btnDecreaseCounter { isVisible() }
        btnOpenTodo { isVisible() }
    }

    fun increaseCounterClick() {
        btnIncreaseCounter {
            click()
        }
    }

    fun decreaseCounterClick() {
        btnDecreaseCounter {
            click()
        }
    }

    fun openTodoScreenClick() {
        btnOpenTodo.click()
    }

    fun checkCounterValue(text: String) {
        tvCounter {
            hasText(text)
        }
    }
}