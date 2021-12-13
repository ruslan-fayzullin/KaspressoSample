package com.example.kaspresso

import org.junit.Test

class CounterTest : BaseCaspressoTest() {

    @Test
    fun increaseCounterFiveTimes() {
        run {
            step("Check views is displayed") {
                CounterScreen {
                    checkTvCounter()
                    checkButtons()
                }
            }
            step("icrease counter by 5") {
                CounterScreen {
                    increaseCounterClick()
                    increaseCounterClick()
                    increaseCounterClick()
                    increaseCounterClick()
                    increaseCounterClick()
                }
            }
            step("assert counter value") {
                CounterScreen {
                    checkCounterValue("Counter: 5")
                }
            }
        }
    }

    @Test
    fun increaseAndDecreaseTest() {
        run {
            step("Check views is displayed") {
                CounterScreen {
                    checkTvCounter()
                    checkButtons()
                }
            }
            step("Increase counter 3 times") {
                CounterScreen {
                    increaseCounterClick()
                    increaseCounterClick()
                    increaseCounterClick()
                }
            }
            step("Decrease counter 2 times") {
                CounterScreen {
                    decreaseCounterClick()
                    decreaseCounterClick()
                }
            }
            step("assert counter value") {
                CounterScreen {
                    checkCounterValue("Counter: 1")
                }
            }
        }
    }

    @Test
    fun checkToastMessage() {
        run {
            step("Check views is displayed") {
                CounterScreen {
                    checkTvCounter()
                    checkButtons()
                }
            }
            step("decrease lower than 0") {
                CounterScreen {
                    decreaseCounterClick()
                }
            }
            step("check toast message") {
                CounterScreen {
                    checkToastVisibility("Can't count lower than 0")
                }
            }
        }
    }

    @Test
    fun checkOpenTodoScreen() {
        run {
            step("Check buttons is displayed") {
                CounterScreen.checkButtons()
            }
            step("Click open todo screen button") {
                CounterScreen.openTodoScreenClick()
            }
            step("Verify destination is TodoFragment") {
                val isTodoFragment = activityTestRule.activity.supportFragmentManager.fragments.firstOrNull {
                    it is TodoFragment
                }

                assert(isTodoFragment != null)
            }
        }
    }

}