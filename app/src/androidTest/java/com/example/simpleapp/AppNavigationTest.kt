package com.example.simpleapp

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

class AppNavigationTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun loginScreenIsDisplayedInitially() {
        composeTestRule.setContent {
            AppNavigation()
        }

        composeTestRule.onNodeWithText("Email").assertIsDisplayed()
    }

    @Test
    fun navigateToWelcomeScreenOnValidInput() {
        val testEmail = "test@example.com"
        val testPassword = "123456"

        composeTestRule.setContent {
            AppNavigation()
        }

        composeTestRule.onNodeWithText("Email").performTextInput(testEmail)
        composeTestRule.onNodeWithText("Пароль").performTextInput(testPassword)
        composeTestRule.onNodeWithText("Войти").performClick()

        composeTestRule.onNodeWithText("Вы вошли как").assertIsDisplayed()
        composeTestRule.onNodeWithText(testEmail).assertIsDisplayed()
    }
}
