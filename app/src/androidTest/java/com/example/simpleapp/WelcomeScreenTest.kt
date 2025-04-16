package com.example.simpleapp

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

class WelcomeScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun displaysWelcomeText() {
        val testLogin = "test@example.com"

        composeTestRule.setContent {
            WelcomeScreen(testLogin)
        }

        composeTestRule.onNodeWithText("Вы вошли как").assertIsDisplayed()
        composeTestRule.onNodeWithText(testLogin).assertIsDisplayed()
    }

    @Test
    fun displaysCorrectLogin() {
        val testLogin = "user@example.com"

        composeTestRule.setContent {
            WelcomeScreen(testLogin)
        }

        composeTestRule.onNodeWithText(testLogin).assertIsDisplayed()
    }
}
