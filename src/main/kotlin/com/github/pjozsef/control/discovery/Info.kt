package com.github.pjozsef.control.discovery

data class Info(
        val name: String,
        val ip:String,
        val os: String,
        val port: Int,
        val timestamp: Long = System.currentTimeMillis()) {

    companion object {
        fun of(input: String): Info? {
            val split = input.split(",")
            if(split.size==4) {
                val name = split[0]
                val ip = split[1]
                val os = split[2]
                val port = split[3].toIntOrNull()
                if(!name.isNullOrBlank() && !ip.isNullOrBlank() && !os.isNullOrBlank() && port != null){
                    return Info(name, ip, os, port)
                }
            }
            return null
        }
    }
}