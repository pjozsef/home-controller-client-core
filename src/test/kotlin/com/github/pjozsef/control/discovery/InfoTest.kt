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
        assertNull(Info.of(",123.765.98.6,OS,55"))
    }

    @Test
    fun testEmptyIp() {
        assertNull(Info.of("hostname,,OS,55"))
    }

    @Test
    fun testEmptyOS() {
        assertNull(Info.of("hostname,123.765.98.6,,55"))
    }

    @Test
    fun testEmptyPort() {
        assertNull(Info.of("hostname,123.765.98.6,OS,"))
    }

    @Test
    fun testInvalidPort() {
        assertNull(Info.of("hostname,123.765.98.6,OS,port"))
    }

    @Test
    fun testValidString() {
        val expected = Info("hostname", "123.765.98.6", "OS", 55, 200)
        val result = Info.of("hostname,123.765.98.6,OS,55")?.copy(timestamp = 200)
        assertEquals(expected, result)
    }
}