package com.github.pjozsef.control.discovery

import org.junit.Assert.*
import org.junit.Test

class InfoTest {
    @Test
    fun testEmptyString() {
        assertNull(Info.of(""))
    }

    @Test
    fun testInvalidString() {
        assertNull(Info.of("bghzuikmnhztf34"))
    }

    @Test
    fun testEmptyHost() {
        assertNull(Info.of(",OS,55"))
    }

    @Test
    fun testEmptyOS() {
        assertNull(Info.of("hostname,,55"))
    }

    @Test
    fun testEmptyPort() {
        assertNull(Info.of("hostname,OS,"))
    }

    @Test
    fun testInvalidPort() {
        assertNull(Info.of("hostname,OS,port"))
    }

    @Test
    fun testValidString() {
        val expected = Info("hostname", "OS", 55)
        val result = Info.of("hostname,OS,55")
        assertEquals(expected, result)
    }
}