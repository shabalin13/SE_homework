package com.example.simpleapp

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

class LoginScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun allFieldsDisplayed() {
        composeTestRule.setContent {
            LoginScreen(onLoginSuccess = {})
        }

        composeTestRule.onNodeWithText("Email").assertIsDisplayed()
        composeTestRule.onNodeWithText("Пароль").assertIsDisplayed()
        composeTestRule.onNodeWithText("Войти").assertIsDisplayed()
    }

    @Test
    fun showsErrorForInvalidEmailAndPassword() {
        composeTestRule.setContent {
            LoginScreen(onLoginSuccess = {})
        }

        composeTestRule.onNodeWithText("Войти").performClick()

        composeTestRule.onNodeWithText("Введите корректный email").assertIsDisplayed()
        composeTestRule.onNodeWithText("Пароль не должен быть пустым").assertIsDisplayed()
    }

    @Test
    fun successfulLoginCallsCallback() {
        var loginSuccessCalled = false

        composeTestRule.setContent {
            LoginScreen(onLoginSuccess = { loginSuccessCalled = true })
        }

        composeTestRule.onNodeWithText("Email").performTextInput("test@example.com")
        composeTestRule.onNodeWithText("Пароль").performTextInput("123456")
        composeTestRule.onNodeWithText("Войти").performClick()

        assert(loginSuccessCalled)
    }
}
