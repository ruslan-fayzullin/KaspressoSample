package com.example.kaspresso

import org.junit.Test
import java.text.SimpleDateFormat
import java.util.*

class TodoTest: BaseCaspressoTest() {

    private val clocks = mutableListOf<String>()

    private fun getClockTime() = SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date())

    @Test
    fun checkTodoAddedToList() {
        run {
            step("Check first screen views") {
                CounterScreen.checkButtons()
            }
            step("Open todo screen") {
                CounterScreen.openTodoScreenClick()
            }
            step("Check views visible") {
                TodoScreen.checkViews()
            }
            step("Type text and click submit button") {
                TodoScreen {
                    typeTodoTitle("first to-do item")
                    btnSubmitClick().also { clocks.add(getClockTime()) }
                    Thread.sleep(1000)
                    clearEtTitle()
                    typeTodoTitle("second to-do item")
                    btnSubmitClick().also { clocks.add(getClockTime()) }
                }
            }
            step("Check todo is added to list") {
                TodoScreen {
                    checkListItemAtPosition(0, "first to-do item", clocks[0])
                    checkListItemAtPosition(1, "second to-do item", clocks[1])
                    Thread.sleep(2000)
                }
            }
            step("Click first ToDo is done") {
                TodoScreen.clickTodoIsDone(0)
            }
            step("Check first ToDo was deleted") {
                TodoScreen {
                    checkListItemAtPosition(0, "second to-do item", clocks[1])
                    checkListItemNotExist(0, "first to-do item")
                    Thread.sleep(2000)
                }
                clocks.removeAt(0)
            }
        }
    }
}