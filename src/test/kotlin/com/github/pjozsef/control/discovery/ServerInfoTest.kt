package com.github.pjozsef.control.discovery

import org.junit.Assert.*
import org.junit.Test

class ServerInfoTest {
    @Test
    fun testEmptyString() {
        assertNull(ServerInfo.of(""))
    }

    @Test
    fun testInvalidString() {
        assertNull(ServerInfo.of("bghzuikmnhztf34"))
    }

    @Test
    fun testEmptyHost() {
        assertNull(ServerInfo.of(",123.765.98.6,OS,55"))
    }

    @Test
    fun testEmptyIp() {
        assertNull(ServerInfo.of("hostname,,OS,55"))
    }

    @Test
    fun testEmptyOS() {
        assertNull(ServerInfo.of("hostname,123.765.98.6,,55"))
    }

    @Test
    fun testEmptyPort() {
        assertNull(ServerInfo.of("hostname,123.765.98.6,OS,"))
    }

    @Test
    fun testInvalidPort() {
        assertNull(ServerInfo.of("hostname,123.765.98.6,OS,port"))
    }

    @Test
    fun testValidString() {
        val expected = ServerInfo("hostname", "123.765.98.6", "OS", 55, 200)
        val result = ServerInfo.of("hostname,123.765.98.6,OS,55")?.copy(timestamp = 200)
        assertEquals(expected, result)
    }
}