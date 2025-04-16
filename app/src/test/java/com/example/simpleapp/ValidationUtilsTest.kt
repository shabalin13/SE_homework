package com.example.simpleapp

import org.junit.Assert.*
import org.junit.Test

class ValidationUtilsTest {

    @Test
    fun `valid email and non-empty password returns true`() {
        val result = validateLogin("user@example.com", "123456")
        assertTrue(result.isEmailValid)
        assertTrue(result.isPasswordValid)
    }

    @Test
    fun `invalid email returns false`() {
        val result = validateLogin("invalid-email", "123456")
        assertFalse(result.isEmailValid)
        assertTrue(result.isPasswordValid)
    }

    @Test
    fun `empty password returns false`() {
        val result = validateLogin("user@example.com", "")
        assertTrue(result.isEmailValid)
        assertFalse(result.isPasswordValid)
    }

    @Test
    fun `both email and password invalid returns false`() {
        val result = validateLogin("bad", "")
        assertFalse(result.isEmailValid)
        assertFalse(result.isPasswordValid)
    }
}
