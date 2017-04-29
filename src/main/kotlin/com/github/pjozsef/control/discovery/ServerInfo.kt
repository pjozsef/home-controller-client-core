package com.github.pjozsef.control.discovery

data class ServerInfo(
        val name: String,
        val ip:String,
        val os: String,
        val port: Int,
        val timestamp: Long = System.currentTimeMillis()) {

    companion object {
        fun of(input: String): ServerInfo? {
            val split = input.split(",")
            if(split.size==4) {
                val name = split[0]
                val ip = split[1]
                val os = split[2]
                val port = split[3].toIntOrNull()
                if(!name.isNullOrBlank() && !ip.isNullOrBlank() && !os.isNullOrBlank() && port != null){
                    return ServerInfo(name, ip, os, port)
                }
            }
            return null
        }
    }
}