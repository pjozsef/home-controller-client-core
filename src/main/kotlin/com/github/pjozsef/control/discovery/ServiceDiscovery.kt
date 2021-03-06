package com.github.pjozsef.control.discovery

import io.reactivex.Observable
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress
import java.net.SocketTimeoutException
import kotlin.concurrent.thread

class ServiceDiscovery(val destination: String, val destinationPort: Int, val token: String) {

    fun discover(): Observable<ServerInfo> = Observable.create<ServerInfo> { emitter ->
        thread(start = true) {
            val udp = DatagramSocket()
            udp.broadcast()

            val buffer = ByteArray(512)
            val packet = DatagramPacket(buffer, buffer.size)

            udp.soTimeout = 1500
            try {
                while (true) {
                    udp.receive(packet)
                    val info = ServerInfo.of(packet.message())
                    info?.let {
                        emitter.onNext(it)
                    }
                }
            } catch (ste: SocketTimeoutException) {
                emitter.onComplete()
            } catch (e: Exception) {
                emitter.onError(e)
            }
            udp.close()
        }
    }

    private fun DatagramSocket.broadcast() {
        val ip = InetAddress.getByName(destination)
        val sendData = token.toByteArray()
        val sendPacket = DatagramPacket(sendData, sendData.size, ip, destinationPort)
        this.send(sendPacket)
    }

    private fun DatagramPacket.message(): String {
        val index = this.data.mapIndexed { index, byte ->
            index to byte
        }.filter {
            val zero: Byte = 0
            it.second == zero
        }.map {
            it.first
        }.first() - 1
        return String(this.data.sliceArray(0..index))
    }
}